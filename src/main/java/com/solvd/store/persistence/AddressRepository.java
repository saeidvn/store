package com.solvd.store.persistence;

import com.solvd.store.domain.Address;

public interface AddressRepository {

    void create (Address address);

    void update (Address address);

    Integer getCount();

    Address get(String country);
}
