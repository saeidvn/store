package com.solvd.store.persistence;

import com.solvd.store.domain.Employee;

public interface IEmployeeRepository {

    void create (Employee employee,  Long storeId, Long passportId, Long addressId);

}
