package com.solvd.store.persistence.impl;

import com.solvd.store.domain.Address;
import com.solvd.store.domain.exeption.ProcessingException;
import com.solvd.store.persistence.IAddressRepository;
import com.solvd.store.persistence.ConnectionPool;

import java.sql.*;

public class AddressRepositoryImpl implements IAddressRepository {

    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    @Override
    public Address create(Address address) {
        Connection connection = CONNECTION_POOL.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "Insert into Addresses(country, city, street, entrance) value (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, address.getCountry());
            preparedStatement.setString(2, address.getCity());
            preparedStatement.setString(3, address.getStreet());
            preparedStatement.setString(4, address.getEntrance());

            preparedStatement.executeUpdate();
            ResultSet gkResultSet = preparedStatement.getGeneratedKeys();
            if (gkResultSet.next()) {
                address.setId(gkResultSet.getLong(1));
            }
        } catch (SQLException e) {
            throw new ProcessingException("Unable to prepare Sql query. " + e.getMessage(), e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
        return address;
    }
}
