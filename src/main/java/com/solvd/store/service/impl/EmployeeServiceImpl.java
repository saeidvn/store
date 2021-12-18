package com.solvd.store.service.impl;

import com.solvd.store.domain.Child;
import com.solvd.store.domain.Employee;
import com.solvd.store.persistence.EmployeeRepository;
import com.solvd.store.persistence.impl.EmployeeMyBatisImpl;
import com.solvd.store.persistence.impl.EmployeeRepositoryImpl;
import com.solvd.store.service.ChildService;
import com.solvd.store.service.EmployeeService;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ChildService childService;

    public EmployeeServiceImpl() {
//        this.employeeRepository = new EmployeeRepositoryImpl();
        this.employeeRepository = new EmployeeMyBatisImpl();
        this.childService = new ChildServiceImpl();
    }

    @Override
    public Employee create(Employee employee) {
        employee.setId(null);
        employeeRepository.create(employee);
        if (employee.getChildren() != null) {
            List<Child> children = employee.getChildren().stream()
                    .map(child -> childService.create(child))
                    .peek(child -> employeeRepository.linkChild(employee.getId(), child.getId()))
                    .collect(Collectors.toList());
            employee.setChildren(children);
        }
        return employee;
    }
}
