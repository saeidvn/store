package com.solvd.store.persistence;

import com.solvd.store.domain.Employee;

import java.util.List;

public interface IEmployeeRepository {

    void create (Employee employee);

    List<Employee> findAll();

}
