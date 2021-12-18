package com.solvd.store.service.impl;

import com.solvd.store.domain.Address;
import com.solvd.store.domain.Store;
import com.solvd.store.persistence.StoreRepository;
import com.solvd.store.persistence.impl.StoreMyBatisImpl;
import com.solvd.store.persistence.impl.StoreRepositoryImpl;
import com.solvd.store.service.AddressService;
import com.solvd.store.service.StoreService;

import java.util.List;

public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;
    private final AddressService addressService;

    public StoreServiceImpl() {
//        this.storeRepository = new StoreRepositoryImpl();
        this.storeRepository = new StoreMyBatisImpl();
        this.addressService = new AddressServiceImpl();
    }

    @Override
    public Store create(Store store) {
        store.setId(null);

        if (store.getAddress() != null) {
            Address address = addressService.create(store.getAddress());
            store.setAddress(address);
        }
        storeRepository.create(store);
        return store;
    }

    @Override
    public List<Store> findAll() {
        return storeRepository.findAll();
    }
}
