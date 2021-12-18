package com.solvd.store.service;

import com.solvd.store.domain.Store;

import java.util.List;

public interface StoreService {

    Store create (Store store);
    List<Store> findAll();
}
