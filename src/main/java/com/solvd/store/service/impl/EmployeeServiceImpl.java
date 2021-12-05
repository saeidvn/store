package com.solvd.store.service.impl;

import com.solvd.store.domain.Child;
import com.solvd.store.domain.Employee;
import com.solvd.store.persistence.IEmployeeRepository;
import com.solvd.store.persistence.impl.EmployeeRepositoryImpl;
import com.solvd.store.service.IChildService;
import com.solvd.store.service.IEmployeeService;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeServiceImpl implements IEmployeeService {

    private final IEmployeeRepository iEmployeeRepository;
    private final IChildService iChildService;

    public EmployeeServiceImpl() {
        this.iEmployeeRepository = new EmployeeRepositoryImpl();
        this.iChildService = new ChildServiceImpl();
    }

    @Override
    public Employee create(Employee employee,  Long storeId, Long passportId, Long addressId) {
        employee.setId(null);
        iEmployeeRepository.create(employee, storeId, passportId, addressId);
        if (employee.getChildren() != null) {
            List<Child> children = employee.getChildren().stream()
                    .map(child -> iChildService.create(child))
                    .collect(Collectors.toList());
        }
        return employee;
    }
}
