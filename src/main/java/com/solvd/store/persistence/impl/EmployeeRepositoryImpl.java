package com.solvd.store.persistence.impl;

import com.solvd.store.domain.Employee;
import com.solvd.store.domain.exeption.ProcessingException;
import com.solvd.store.persistence.ConnectionPool;
import com.solvd.store.persistence.EmployeeRepository;

import java.sql.*;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    @Override
    public void create(Employee employee) {
//        Connection connection = CONNECTION_POOL.getConnection();
//        try (PreparedStatement preparedStatement = connection.prepareStatement(
//                "Insert into Employees(store_id, passport_id, address_id, firstName, lastName, dateOfBirth)" +
//                        " value (?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
//            preparedStatement.setLong(1, storeId);
//            preparedStatement.setLong(2, passportId);
//            preparedStatement.setLong(3, addressId);
//            preparedStatement.setString(4, employee.getFirstName());
//            preparedStatement.setString(5, employee.getLastName());
//            preparedStatement.setDate(6, Date.valueOf(employee.getDateOfBirth()));
//
//            preparedStatement.executeUpdate();
//            ResultSet gkResultSet = preparedStatement.getGeneratedKeys();
//            if (gkResultSet.next()) {
//                employee.setId(gkResultSet.getLong(1));
//            }
//        } catch (SQLException e) {
//            throw new ProcessingException("Can't create employee.", e);
//        } finally {
//            CONNECTION_POOL.releaseConnection(connection);
//        }
    }

    @Override
    public void linkChild(Long employeeId, Long childId) {
        Connection connection = CONNECTION_POOL.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "Insert into employee_children(employee_id, child_id)" +
                        " value (?,?)", Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setLong(1, employeeId);
            preparedStatement.setLong(2, childId);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new ProcessingException("Unable to prepare Sql query. ", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }
}
