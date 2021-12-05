package com.solvd.store.service.impl;

import com.solvd.store.domain.Address;
import com.solvd.store.domain.Store;
import com.solvd.store.persistence.IStoreRepository;
import com.solvd.store.persistence.impl.StoreRepositoryImpl;
import com.solvd.store.service.IAddressService;
import com.solvd.store.service.IStoreService;

import java.util.List;

public class StoreServiceImpl implements IStoreService {

    private final IStoreRepository iStoreRepository;
    private final IAddressService iAddressService;

    public StoreServiceImpl() {
        this.iStoreRepository = new StoreRepositoryImpl();
        this.iAddressService = new AddressServiceImpl();
    }

    @Override
    public Store create(Store store) {
        store.setId(null);

        if (store.getAddress() != null) {
            Address address = iAddressService.create(store.getAddress());
            store.setAddress(address);
        }
        iStoreRepository.create(store, store.getAddress().getId());
        return store;
    }

    @Override
    public List<Store> selectAll() {
        iStoreRepository.findAll();
        return null;
    }
}
