package com.solvd.store.service.impl;

import com.solvd.store.domain.Address;
import com.solvd.store.persistence.AddressRepository;
import com.solvd.store.persistence.impl.AddressMyBatisImpl;
import com.solvd.store.persistence.impl.AddressRepositoryImpl;
import com.solvd.store.service.AddressService;

public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    public AddressServiceImpl() {
//        this.addressRepository = new AddressRepositoryImpl();
        this.addressRepository = new AddressMyBatisImpl();
    }

    @Override
    public Address create(Address address) {
        address.setId(null);
        addressRepository.create(address);
        return address;
    }
}
