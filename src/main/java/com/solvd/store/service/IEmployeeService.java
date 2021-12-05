package com.solvd.store.service;

import com.solvd.store.domain.Employee;

public interface IEmployeeService {

    Employee create (Employee employee,  Long storeId, Long passportId, Long addressId);

}
