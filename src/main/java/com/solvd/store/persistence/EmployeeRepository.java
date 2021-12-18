package com.solvd.store.persistence;

import com.solvd.store.domain.Employee;

public interface EmployeeRepository {

    void create(Employee employee);

    void linkChild(Long employeeId, Long childId);
}
