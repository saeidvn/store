package com.solvd.store.persistence.impl;

import com.solvd.store.domain.Passport;
import com.solvd.store.domain.exeption.ProcessingException;
import com.solvd.store.persistence.ConnectionPool;
import com.solvd.store.persistence.PassportRepository;

import java.sql.*;

public class PassportRepositoryImpl implements PassportRepository {

    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    @Override
    public void create(Passport passport) {
        Connection connection = CONNECTION_POOL.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "Insert into Passports(number, expire_date) value (?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, passport.getNumber());
            preparedStatement.setDate(2, Date.valueOf(passport.getExpireDate()));

            preparedStatement.executeUpdate();
            ResultSet gkResultSet = preparedStatement.getGeneratedKeys();
            if (gkResultSet.next()) {
                passport.setId(gkResultSet.getLong(1));
            }
        } catch (SQLException e) {
            throw new ProcessingException("Unable to prepare Sql query. " + e.getMessage(), e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }
}
