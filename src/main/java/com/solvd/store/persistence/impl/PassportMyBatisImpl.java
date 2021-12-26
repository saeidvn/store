package com.solvd.store.persistence.impl;

import com.solvd.store.domain.Address;
import com.solvd.store.domain.Passport;
import com.solvd.store.persistence.AddressRepository;
import com.solvd.store.persistence.MybatisConfig;
import com.solvd.store.persistence.PassportRepository;
import org.apache.ibatis.session.SqlSession;

import java.time.LocalDate;

public class PassportMyBatisImpl implements PassportRepository {

    @Override
    public void create(Passport passport) {
        try (SqlSession sqlSession = MybatisConfig.getSqlSessionFactory().openSession(true)) {
            PassportRepository passportRepository = sqlSession.getMapper(PassportRepository.class);
            passportRepository.create(passport);
        }
    }

    @Override
    public void update(Passport passport) {
        try (SqlSession sqlSession = MybatisConfig.getSqlSessionFactory().openSession(true)) {
            PassportRepository passportRepository = sqlSession.getMapper(PassportRepository.class);
            passportRepository.update(passport);
        }
    }

    @Override
    public Passport get(LocalDate expireDate) {
        try (SqlSession sqlSession = MybatisConfig.getSqlSessionFactory().openSession(true)) {
            PassportRepository passportRepository = sqlSession.getMapper(PassportRepository.class);
            return passportRepository.get(expireDate);
        }
    }

}
