package com.solvd.store.persistence.impl;

import com.solvd.store.domain.Child;
import com.solvd.store.persistence.ChildRepository;
import com.solvd.store.persistence.MybatisConfig;
import org.apache.ibatis.session.SqlSession;

public class ChildMyBatisImpl implements ChildRepository {

    @Override
    public void create(Child child) {
        try (SqlSession sqlSession = MybatisConfig.getSqlSessionFactory().openSession(true)) {
            ChildRepository childRepository = sqlSession.getMapper(ChildRepository.class);
            childRepository.create(child);
        }
    }
}
