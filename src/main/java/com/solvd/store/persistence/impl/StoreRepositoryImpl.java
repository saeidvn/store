package com.solvd.store.persistence.impl;

import com.solvd.store.domain.Store;
import com.solvd.store.domain.exeption.ProcessingException;
import com.solvd.store.persistence.ConnectionPool;
import com.solvd.store.persistence.IStoreRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StoreRepositoryImpl implements IStoreRepository {

    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    @Override
    public void create(Store store, Long addressId) {
        Connection connection = CONNECTION_POOL.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "Insert into Stores(address_id, name) value (?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setLong(1, addressId);
            preparedStatement.setString(2, store.getName());

            preparedStatement.executeUpdate();
            ResultSet gkResultSet = preparedStatement.getGeneratedKeys();
            if (gkResultSet.next()) {
                store.setId(gkResultSet.getLong(1));
            }
        } catch (SQLException e) {
            throw new ProcessingException("Unable to prepare Sql query. ");
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public List<Store> findAll() {
        Connection connection = CONNECTION_POOL.getConnection();
        String query = "select s.id as store_id, s.name as store_name, e.first_name, e.last_name, e.date_of_birth," +
                " p.id as passport_id, p.number as passport_number, p.expire_date as passport_expireDate" +
                " from Stores as s left join Employees as e on e.store_id = s.id left join" +
                " Passports as p on e.passport_id = p.id";

        List<Store> stores = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet gkResultSet = preparedStatement.getGeneratedKeys();
        } catch (SQLException e) {
            throw new RuntimeException(" Cannot select ", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        } return stores;
    }
}
