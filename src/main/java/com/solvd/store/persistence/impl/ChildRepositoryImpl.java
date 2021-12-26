package com.solvd.store.persistence.impl;

import com.solvd.store.domain.Child;
import com.solvd.store.domain.exeption.ProcessingException;
import com.solvd.store.persistence.ConnectionPool;
import com.solvd.store.persistence.ChildRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChildRepositoryImpl implements ChildRepository {

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
            throw new ProcessingException("Can't create. ", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    public static List<Child> mapChildren(ResultSet resultSet) {
        List<Child> children = new ArrayList<>();
        try {
            long id = resultSet.getLong("child_id");
            if (id != 0) {
                Child child = checkExistence(id, children);
                child.setName(resultSet.getString("child_name"));
                child.setAge(resultSet.getInt("child_age"));
            }
        } catch (SQLException e) {
            throw new ProcessingException("Map exception", e);
        }
        return children;
    }

    private static Child checkExistence(Long id, List<Child> children) {
        Child result = null;
        for (Child child : children) {
            if (child.getId().equals(id)) {
                result = child;
            }
        }
        if (result == null) {
            Child createdChild = new Child();
            createdChild.setId(id);
            children.add(createdChild);
            result = createdChild;
        }
        return result;
    }
}
