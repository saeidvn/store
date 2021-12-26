package com.solvd.store.service;

import com.solvd.store.domain.Address;

import java.util.List;

public interface AddressService {

    Address create (Address address);

    void update (Address address);

    Integer getCount();

    Address get(String country);

//    List<Address> getAll();
}
