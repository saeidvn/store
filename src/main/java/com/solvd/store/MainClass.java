package com.solvd.store;

import com.solvd.store.domain.*;
import com.solvd.store.service.IAddressService;
import com.solvd.store.service.IStoreService;
import com.solvd.store.service.impl.AddressServiceImpl;
import com.solvd.store.service.impl.StoreServiceImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class MainClass {

    private static LocalDate convertStringToLocalDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(date, formatter);
    }

    public static void main(String[] args) {

        Address address1 = new Address();
        address1.setCountry("Country1");
        address1.setCity("City1");
        address1.setStreet("Street1");
        address1.setEntrance("Entrance1");

        Address address2 = new Address();
        address2.setCountry("Country2");
        address2.setCity("City2");
        address2.setStreet("Street2");
        address2.setEntrance("Entrance2");

        Address address3 = new Address();
        address3.setCountry("Country3");
        address3.setCity("City3");
        address3.setStreet("Street3");
        address3.setEntrance("Entrance3");

        Address address4 = new Address();
        address4.setCountry("Country4");
        address4.setCity("City4");
        address4.setStreet("Street4");
        address4.setEntrance("Entrance4");

        Address address5 = new Address();
        address5.setCountry("Country5");
        address5.setCity("City5");
        address5.setStreet("Street5");
        address5.setEntrance("Entrance5");

        Address address6 = new Address();
        address6.setCountry("Country6");
        address6.setCity("City6");
        address6.setStreet("Street6");
        address6.setEntrance("Entrance6");

        Address address7 = new Address();
        address7.setCountry("Country7");
        address7.setCity("City7");
        address7.setStreet("Street7");
        address7.setEntrance("Entrance7");

        Passport passport1 = new Passport();
        passport1.setNumber("1");
        passport1.setExpireDate(convertStringToLocalDate("01-01-2023"));
        passport1.setVisa(null);

        Passport passport2 = new Passport();
        passport2.setNumber("2");
        passport2.setExpireDate(convertStringToLocalDate("02-02-2023"));
        passport2.setVisa(null);

        Passport passport3 = new Passport();
        passport3.setNumber("3");
        passport3.setExpireDate(convertStringToLocalDate("03-03-2023"));
        passport3.setVisa(null);

        Passport passport4 = new Passport();
        passport4.setNumber("4");
        passport4.setExpireDate(convertStringToLocalDate("04-04-2023"));
        passport4.setVisa(null);

        Passport passport5 = new Passport();
        passport4.setNumber("5");
        passport4.setExpireDate(convertStringToLocalDate("04-04-2023"));
        passport4.setVisa(null);

        Child child1 = new Child();
        child1.setName("Child1" + UUID.randomUUID());
        child1.setAge(1);

        Child child2 = new Child();
        child2.setName("Child2" + UUID.randomUUID());
        child2.setAge(2);

        Child child3 = new Child();
        child3.setName("Child3" + UUID.randomUUID());
        child3.setAge(3);

        List<Child> children = Arrays.asList(child1, child2, child3);

        Employee employee1 = new Employee();
        employee1.setFirstName("FirstName1");
        employee1.setLastName("LastName1");
        employee1.setDateOfBirth(convertStringToLocalDate("01-01-2021"));
        employee1.setPassport(passport1);
        employee1.setChildren(children);
        employee1.setAddress(address1);

        Employee employee2 = new Employee();
        employee2.setFirstName("FirstName2");
        employee2.setLastName("LastName2");
        employee2.setDateOfBirth(convertStringToLocalDate("02-02-2021"));
        employee2.setPassport(passport2);
        employee2.setChildren(children);
        employee2.setAddress(address2);

        Employee employee3 = new Employee();
        employee3.setFirstName("FirstName3");
        employee3.setLastName("LastName3");
        employee3.setDateOfBirth(convertStringToLocalDate("03-03-2021"));
        employee3.setPassport(passport3);
        employee3.setChildren(children);
        employee3.setAddress(address3);

        Employee employee4 = new Employee();
        employee4.setFirstName("FirstName4");
        employee4.setLastName("LastName4");
        employee4.setDateOfBirth(convertStringToLocalDate("04-04-2021"));
        employee4.setPassport(passport4);
        employee4.setAddress(address4);

        List<Employee> employees = Arrays.asList(employee1, employee2, employee3, employee4);

        Store store1 = new Store();
        store1.setName("Store1");
        store1.setAddress(address5);
        store1.setEmployees(employees);
        store1.setEmployees(employees);

        Store store2 = new Store();
        store2.setName("Store2");
        store2.setAddress(address6);
        store2.setEmployees(employees);

        Store store3 = new Store();
        store3.setName("Store3");
        store3.setAddress(address7);
        store3.setEmployees(employees);

        Store store = new Store();
        store.setName("Store" + UUID.randomUUID());
        store.setAddress(address1);
        store.setEmployees(employees);

        IAddressService iAddressService = new AddressServiceImpl();
        address3 = iAddressService.create(address3);

        IStoreService iStoreService = new StoreServiceImpl();
        store3 = iStoreService.create(store3);

        System.out.println();


    }
}
