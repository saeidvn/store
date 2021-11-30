package com.solvd.store.persistence;

import com.solvd.store.domain.Address;

import java.util.List;

public interface IAddressRepository {

    void create (Address address);

    List<Address> findAll();

}
