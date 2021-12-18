package com.solvd.store.persistence.impl;

import com.solvd.store.domain.Passport;
import com.solvd.store.persistence.MybatisConfig;
import com.solvd.store.persistence.PassportRepository;
import org.apache.ibatis.session.SqlSession;

public class PassportMyBatisImpl implements PassportRepository {

    @Override
    public void create(Passport passport) {
        try (SqlSession sqlSession = MybatisConfig.getSqlSessionFactory().openSession(true)) {
            PassportRepository passportRepository = sqlSession.getMapper(PassportRepository.class);
            passportRepository.create(passport);
        }
    }

}
