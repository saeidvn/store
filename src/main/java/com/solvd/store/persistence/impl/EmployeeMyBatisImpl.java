package com.solvd.store.persistence.impl;

import com.solvd.store.domain.Employee;
import com.solvd.store.persistence.ChildRepository;
import com.solvd.store.persistence.EmployeeRepository;
import com.solvd.store.persistence.MybatisConfig;
import org.apache.ibatis.session.SqlSession;

public class EmployeeMyBatisImpl implements EmployeeRepository {

    @Override
    public void create(Employee employee) {
        try (SqlSession sqlSession = MybatisConfig.getSqlSessionFactory().openSession(true)) {
            EmployeeRepository employeeRepository = sqlSession.getMapper(EmployeeRepository.class);
            employeeRepository.create(employee);
        }
    }

    @Override
    public void linkChild(Long employeeId, Long childId) {

    }
}
