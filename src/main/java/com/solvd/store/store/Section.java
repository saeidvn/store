package com.solvd.store.store;

import java.util.ArrayList;

public class Section {

    private String name;
    private Integer number;
    private Employee manager;
    private Employee security;
    private ArrayList<Product> products = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public Employee getSecurity() {
        return security;
    }

    public void setSecurity(Employee security) {
        this.security = security;
    }
}
