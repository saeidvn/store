package com.solvd.store.persistence.impl;

import com.solvd.store.domain.Store;
import com.solvd.store.persistence.MybatisConfig;
import com.solvd.store.persistence.StoreRepository;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StoreMyBatisImpl implements StoreRepository {

    @Override
    public void create(Store store) {
        try (SqlSession sqlSession = MybatisConfig.getSqlSessionFactory().openSession(true)) {
            StoreRepository storeRepository = sqlSession.getMapper(StoreRepository.class);
            storeRepository.create(store);
        }
    }

    @Override
    public List<Store> findAll() {
        try (SqlSession session = MybatisConfig.getSqlSessionFactory().openSession(true)) {
            StoreRepository storeRepository = session.getMapper(StoreRepository.class);
            return storeRepository.findAll();
        }
    }
}
