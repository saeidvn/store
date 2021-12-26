package com.solvd.store;

import com.solvd.store.domain.*;
import com.solvd.store.service.*;
import com.solvd.store.service.impl.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class MainClass {

    public static void main(String[] args) {
        Passport passportTest = new Passport();
        passportTest.setNumber("" + UUID.randomUUID());
        passportTest.setExpireDate(LocalDate.of(2023, 03, 03));
        passportTest.setVisa(null);

        PassportService passportService = new PassportServiceImpl();
        passportService.create(passportTest);

        Address addressTest = new Address();
        addressTest.setCountry("Country");
        addressTest.setCity("City");
        addressTest.setStreet("Street");
        addressTest.setEntrance("Entrance");

        AddressService addressService = new AddressServiceImpl();
        addressService.create(addressTest);

        Child childTest = new Child();
        childTest.setName("Child" + UUID.randomUUID());
        childTest.setAge(3);

        List<Child> childrenTest = Arrays.asList(childTest);

        ChildService childService = new ChildServiceImpl();

        childrenTest.forEach(child -> childService.create(child));

        Store storeTest = new Store();
        storeTest.setName("Store");
        storeTest.setAddress(addressTest);

        StoreService storeService = new StoreServiceImpl();
        storeService.create(storeTest);

        Employee employeeTest = new Employee();
        employeeTest.setFirstName("FirstName");
        employeeTest.setLastName("LastName");
        employeeTest.setDateOfBirth(LocalDate.of(2021, 01, 01));
        employeeTest.setPassport(passportTest);
        employeeTest.setChildren(childrenTest);
        employeeTest.setAddress(addressTest);
        employeeTest.setStore(storeTest);

        EmployeeService employeeService = new EmployeeServiceImpl();
        employeeService.create(employeeTest);

        List<Store> stores = storeService.findAll();

        System.out.println(stores);

        stores.forEach(store -> System.out.println(store.getEmployees()));
    }
}
