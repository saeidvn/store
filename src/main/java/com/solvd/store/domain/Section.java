package com.solvd.store.domain;

import java.util.List;

public class Section {

    private Long id;
    private String name;
    private Integer number;
    private Employee manager;
    private Employee security;
    private List<Product> products;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

//    public void addProduct(Product product) {
//        this.products.add(product);
//    }

    public Employee getSecurity() {
        return security;
    }

    public void setSecurity(Employee security) {
        this.security = security;
    }
}
