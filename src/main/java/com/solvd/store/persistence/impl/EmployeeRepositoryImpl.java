package com.solvd.store.persistence.impl;

import com.solvd.store.domain.Employee;
import com.solvd.store.domain.exeption.ProcessingException;
import com.solvd.store.persistence.ConnectionPool;
import com.solvd.store.persistence.IEmployeeRepository;

import java.sql.*;
import java.time.LocalDate;

public class EmployeeRepositoryImpl implements IEmployeeRepository {

    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    @Override
    public void create(Employee employee, Long storeId, Long passportId, Long addressId) {
        Connection connection = CONNECTION_POOL.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "Insert into Employees(store_id, passport_id, address_id, firstName, lastName, dateOfBirth)" +
                        " value (?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setLong(1, storeId);
            preparedStatement.setLong(2, passportId);
            preparedStatement.setLong(3, addressId);
            preparedStatement.setString(4, employee.getFirstName());
            preparedStatement.setString(5, employee.getLastName());
            preparedStatement.setDate(6, Date.valueOf(employee.getDateOfBirth()));

            preparedStatement.executeUpdate();
            ResultSet gkResultSet = preparedStatement.getGeneratedKeys();
            if (gkResultSet.next()) {
                employee.setId(gkResultSet.getLong(1));
            }
        } catch (SQLException e) {
            throw new ProcessingException("Unable to prepare Sql query. " + e.getMessage(), e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }

//        public void
    }
}
