package com.solvd.store.persistence;

import com.solvd.store.domain.Store;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StoreRepository {

    void create (Store store);

    List<Store> findAll();

}
