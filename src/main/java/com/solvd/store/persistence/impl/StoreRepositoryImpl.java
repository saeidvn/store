package com.solvd.store.persistence.impl;

import com.solvd.store.domain.Store;
import com.solvd.store.domain.exeption.ProcessingException;
import com.solvd.store.persistence.ConnectionPool;
import com.solvd.store.persistence.StoreRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StoreRepositoryImpl implements StoreRepository {

    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    private static final String QUERY = "select s.id as store_id, s.name as store_name," +
            " e.first_name, e.last_name, e.date_of_birth," +
            " p.id as passport_id, p.number as passport_number, p.expire_date as passport_expireDate" +
            " from Stores as s left join Employees as e on e.store_id = s.id left join" +
            " Passports as p on e.passport_id = p.id";

    @Override
    public void create(Store store) {
//        Connection connection = CONNECTION_POOL.getConnection();
//        try (PreparedStatement preparedStatement = connection.prepareStatement(
//                "Insert into Stores(address_id, name) value (?, ?)", Statement.RETURN_GENERATED_KEYS)) {
//            preparedStatement.setLong(1, addressId);
//            preparedStatement.setString(2, store.getName());
//
//            preparedStatement.executeUpdate();
//            ResultSet resultSet = preparedStatement.getGeneratedKeys();
//            while (resultSet.next()) {
//                store.setId(resultSet.getLong(1));
//            }
//        } catch (SQLException e) {
//            throw new ProcessingException("Can't create.", e);
//        } finally {
//            CONNECTION_POOL.releaseConnection(connection);
//        }
    }

    @Override
    public List<Store> findAll() {
        List<Store> stores = new ArrayList<>();
        Connection connection = CONNECTION_POOL.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            ResultSet resultSet = preparedStatement.executeQuery();
            stores = mapStores(resultSet);
        } catch (SQLException e) {
            throw new ProcessingException("Can't find employees.", e);
        }
        return stores;
    }

    public static List<Store> mapStores(ResultSet resultSet) {
        List<Store> stores = new ArrayList<>();
        try {
            while (resultSet.next()) {
                Long id = resultSet.getLong("store_id");
                Store store = checkExistence(id, stores);
                store.setName(resultSet.getString("store_name"));
            }
        } catch (SQLException e) {
            throw new ProcessingException("Map exception", e);
        }
        return stores;
    }

    private static Store checkExistence(Long id, List<Store> stores) {
        Store result = null;
        for (Store store : stores) {
            if (store.getId().equals(id)) {
                result = store;
            }
        }
        if (result == null) {
            Store createdStore = new Store();
            createdStore.setId(id);
            stores.add(createdStore);
            result = createdStore;
        }
        return result;
    }

}
