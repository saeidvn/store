package com.solvd.store.persistence.impl;

import com.solvd.store.domain.Child;
import com.solvd.store.domain.exeption.ProcessingException;
import com.solvd.store.persistence.ConnectionPool;
import com.solvd.store.persistence.IChildRepository;

import java.sql.*;
import java.util.List;

public class ChildRepositoryImpl implements IChildRepository {

    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    @Override
    public void create(Child child) {
        Connection connection = CONNECTION_POOL.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "Insert into Children(name, age) value (?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, child.getName());
            preparedStatement.setLong(2, child.getAge());

            preparedStatement.executeUpdate();
            ResultSet gkResultSet = preparedStatement.getGeneratedKeys();
            if (gkResultSet.next()) {
                child.setId(gkResultSet.getLong(1));
            }
        } catch (SQLException e) {
            throw new ProcessingException("Unable to prepare Sql query. " + e.getMessage(), e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public Child create(List<Child> children) {
        return null;
    }
}
