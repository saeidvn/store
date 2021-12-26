package com.solvd.store.persistence.impl;

import com.solvd.store.domain.Address;
import com.solvd.store.domain.Passport;
import com.solvd.store.domain.exeption.ProcessingException;
import com.solvd.store.persistence.ConnectionPool;
import com.solvd.store.persistence.PassportRepository;

import java.sql.*;
import java.time.LocalDate;

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
            throw new ProcessingException("Can't create.", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public void update(Passport passport) {
        Connection connection = CONNECTION_POOL.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "UPDATE Passports SET number = ?, expire_date = ?")) {
            preparedStatement.setString(1, passport.getNumber());
            preparedStatement.setDate(2, Date.valueOf(passport.getExpireDate()));

            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            throw new ProcessingException("Can't update passport. ");
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public Passport get(LocalDate expireDate) {
        return null;
    }
}
