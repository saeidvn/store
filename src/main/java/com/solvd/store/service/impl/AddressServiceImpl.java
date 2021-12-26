package com.solvd.store.service.impl;

import com.solvd.store.domain.Address;
import com.solvd.store.domain.exeption.ProcessingException;
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

    @Override
    public void update(Address address) {
        addressRepository.update(address);
    }

    @Override
    public Integer getCount() {
        return addressRepository.getCount();
    }

    @Override
    public Address get(String country) {
        Address address = addressRepository.get(country);
        if(address == null) {
            throw new ProcessingException("Object not found.");
        }
        return address;
    }
}
