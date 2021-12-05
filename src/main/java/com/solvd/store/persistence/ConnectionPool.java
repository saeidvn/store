package com.solvd.store.persistence;

import com.solvd.store.domain.exeption.ProcessingException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ConnectionPool {

    public volatile static ConnectionPool instance;

    static {
        try {
            Class.forName(PropertiesHolder.getProperty(PropertiesHolder.Name.DRIVER));
        }catch (ClassNotFoundException e) {
            throw new ProcessingException("Unable to register Mysql driver" + e.getMessage(), e);
        }
    }

    private final List<Connection> connections;

    private ConnectionPool(int sizeOfPool) {
        this.connections = new ArrayList<>(sizeOfPool);
        IntStream.range(0, sizeOfPool).boxed()
                .forEach(index -> connections.add(createConnection()));
    }

    private Connection createConnection() {
        try {
            return DriverManager.getConnection(
                    PropertiesHolder.getProperty(PropertiesHolder.Name.URL),
                    PropertiesHolder.getProperty(PropertiesHolder.Name.USERNAME),
                    PropertiesHolder.getProperty(PropertiesHolder.Name.PASSWORD));
        }catch (SQLException e) {
            throw new ProcessingException("Unable to create database connection. " + e.getMessage(), e);
        }
    }

    public Connection getConnection() {
        synchronized (connections) {
            if (connections.isEmpty()) {
                try {
                    while (connections.isEmpty()) {
                        connections.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return connections.remove(connections.size() - 1);
        }
    }

    public void releaseConnection(Connection connection) {
        synchronized (connections) {
            connections.add(connection);
            connections.notifyAll();
        }
    }

    public static synchronized ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool(Integer.parseInt(PropertiesHolder
                    .getProperty(PropertiesHolder.Name.CONNECTION_POOL_SIZE)));
        }
        return instance;
    }
}