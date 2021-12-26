package com.solvd.store.persistence.impl;

import com.solvd.store.domain.Address;
import com.solvd.store.persistence.AddressRepository;
import com.solvd.store.persistence.MybatisConfig;
import org.apache.ibatis.session.SqlSession;

public class AddressMyBatisImpl implements AddressRepository {

    @Override
    public void create(Address address) {
        try (SqlSession sqlSession = MybatisConfig.getSqlSessionFactory().openSession(true)) {
            AddressRepository addressRepository = sqlSession.getMapper(AddressRepository.class);
            addressRepository.create(address);
        }
    }

    @Override
    public void update(Address address) {
        try (SqlSession sqlSession = MybatisConfig.getSqlSessionFactory().openSession(true)) {
            AddressRepository addressRepository = sqlSession.getMapper(AddressRepository.class);
            addressRepository.update(address);
        }
    }

    @Override
    public Integer getCount() {
        try (SqlSession sqlSession = MybatisConfig.getSqlSessionFactory().openSession(true)) {
            AddressRepository addressRepository = sqlSession.getMapper(AddressRepository.class);
            return addressRepository.getCount();
        }
    }

    @Override
    public Address get(String country) {
        try (SqlSession sqlSession = MybatisConfig.getSqlSessionFactory().openSession(true)) {
            AddressRepository addressRepository = sqlSession.getMapper(AddressRepository.class);
            return addressRepository.get(country);
        }
    }


}
