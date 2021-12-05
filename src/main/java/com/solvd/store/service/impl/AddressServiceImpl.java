package com.solvd.store.service.impl;

import com.solvd.store.domain.Address;
import com.solvd.store.persistence.impl.AddressRepositoryImpl;
import com.solvd.store.service.IAddressService;

public class AddressServiceImpl implements IAddressService {

    private final AddressRepositoryImpl addressRepository;

    public AddressServiceImpl() {
        this.addressRepository = new AddressRepositoryImpl();
    }

    @Override
    public Address create(Address address) {
        address.setId(null);
        addressRepository.create(address);
        return address;
    }
}
