package com.solvd.store.persistence;

import com.solvd.store.domain.Store;

import java.util.List;

public interface IStoreRepository {

    void create (Store store, Long addressId);
    List<Store> findAll();

}
