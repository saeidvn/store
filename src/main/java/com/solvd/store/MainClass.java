package com.solvd.store;

import com.solvd.store.store.Employee;
import com.solvd.store.store.Product;
import com.solvd.store.store.Section;
import com.solvd.store.store.Store;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MainClass {

    private static final Logger LOGGER = LogManager.getLogger(MainClass.class);

    private static LocalDate convertStringToLocalDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
        return LocalDate.parse(date, formatter);
    }

    public static void main(String[] args) {

        Store store = new Store();

        Section warehouse = new Section();
        Section storage = new Section();
        Section refrigerator = new Section();
        Section cargoTransportation = new Section();
        Section cashDesk = new Section();
        Section cashRegisterMachine = new Section();

        Section managerSection = new Section();
        Section securitySection = new Section();
        Section meatSection = new Section();
        Section fruitSection = new Section();
        Section breadSection = new Section();
        Section dairyProductSection = new Section();
        Section beverageSection = new Section();
        Section grocerySection = new Section();
        Section householdGoodSection = new Section();
        Section goodForAnimalSection = new Section();

//        Employee manager = new Employee();
        Employee security = new Employee();
        Employee cashier = new Employee();
        Employee sorter = new Employee();
        Employee loader = new Employee();
        Employee cleaner = new Employee();

        Employee meatManager = new Employee();
        meatManager.setName("Jack");
        meatManager.setIdNumber(1);
        meatManager.setDateOfBirth(convertStringToLocalDate("1980-01-01"));

        meatSection.setName("Meat Sector");
        meatSection.setNumber(3);
        meatSection.setManager(meatManager);

        Product pork = new Product();
        pork.setName("Pork");
        pork.setId(1);
        pork.setCreatedDate(convertStringToLocalDate("2021-01-01"));
        pork.setExpireDate(convertStringToLocalDate("2022-01-01"));

        Product lamb = new Product();
        lamb.setName("Lamb");
        lamb.setId(2);
        lamb.setCreatedDate(convertStringToLocalDate("2021-01-01"));
        lamb.setExpireDate(convertStringToLocalDate("2022-01-01"));

        meatSection.addProduct(pork);
        meatSection.addProduct(lamb);

        store.addSection(meatSection);

        Employee meatSorter = new Employee();
        meatSorter.setName("Jannie");
        meatSorter.setIdNumber(1);
        meatSorter.setDateOfBirth(convertStringToLocalDate("1980-01-01"));

        Employee managerStore = new Employee();
        managerStore.setName("Rose");
        managerStore.setIdNumber(1);
        managerStore.setDateOfBirth(convertStringToLocalDate("1970-01-01"));

        managerSection.setName("Manager room");
        managerSection.setNumber(1);
        managerSection.setManager(managerStore);

        store.addSection(managerSection);

        Employee securityStore = new Employee();
        securityStore.setName("Arnold");
        securityStore.setIdNumber(1);
        securityStore.setDateOfBirth(convertStringToLocalDate("2000-05-05"));

        securitySection.setName("Security room");
        securitySection.setNumber(2);
        securitySection.setSecurity(securityStore);

        store.addSection(managerSection);

        Employee fruitManager = new Employee();
        fruitManager.setName("Jasmin");
        fruitManager.setIdNumber(1);
        fruitManager.setDateOfBirth(convertStringToLocalDate("1975-02-02"));

        fruitSection.setName("Fruit Sector");
        fruitSection.setNumber(4);
        fruitSection.setManager(fruitManager);

        store.addSection(fruitSection);

        Employee breadManager = new Employee();
        breadManager.setName("Caitlin");
        breadManager.setIdNumber(1);
        breadManager.setDateOfBirth(convertStringToLocalDate("1978-03-05"));

        breadSection.setName("Bread Sector");
        breadSection.setNumber(5);
        breadSection.setManager(breadManager);

        store.addSection(breadSection);

        Employee dairyProductManager = new Employee();
        dairyProductManager.setName("Jhonny");
        dairyProductManager.setIdNumber(1);
        dairyProductManager.setDateOfBirth(convertStringToLocalDate("1980-09-02"));

        dairyProductSection.setName("Dairy Products Sector");
        dairyProductSection.setNumber(6);
        dairyProductSection.setManager(dairyProductManager);

        store.addSection(dairyProductSection);

        Employee beverageManager = new Employee();
        beverageManager.setName("Angela");
        beverageManager.setIdNumber(1);
        beverageManager.setDateOfBirth(convertStringToLocalDate("1996-11-12"));

        beverageSection.setName("Beverage Sector");
        beverageSection.setNumber(7);
        beverageSection.setManager(beverageManager);

        store.addSection(beverageSection);

        Employee groceryManager = new Employee();
        groceryManager.setName("Galina");
        groceryManager.setIdNumber(1);
        groceryManager.setDateOfBirth(convertStringToLocalDate("1991-01-28"));

        grocerySection.setName("Grocery Sector");
        grocerySection.setNumber(8);
        grocerySection.setManager(groceryManager);

        store.addSection(grocerySection);

        Employee householdGoodManager = new Employee();
        householdGoodManager.setName("Bruce");
        householdGoodManager.setIdNumber(1);
        householdGoodManager.setDateOfBirth(convertStringToLocalDate("1999-10-20"));

        householdGoodSection.setName("Household goods Sector");
        householdGoodSection.setNumber(9);
        householdGoodSection.setManager(householdGoodManager);

        store.addSection(householdGoodSection);

        Employee goodForAnimalManager = new Employee();
        goodForAnimalManager.setName("Rose");
        goodForAnimalManager.setIdNumber(1);
        goodForAnimalManager.setDateOfBirth(convertStringToLocalDate("2002-08-08"));

        goodForAnimalSection.setName("Goods for animal Sector");
        goodForAnimalSection.setNumber(10);
        goodForAnimalSection.setManager(goodForAnimalManager);

        store.addSection(goodForAnimalSection);


    }

}
