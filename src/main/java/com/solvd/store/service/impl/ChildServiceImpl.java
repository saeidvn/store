package com.solvd.store.service.impl;

import com.solvd.store.domain.Child;
import com.solvd.store.persistence.ChildRepository;
import com.solvd.store.persistence.impl.ChildMyBatisImpl;
import com.solvd.store.persistence.impl.ChildRepositoryImpl;
import com.solvd.store.service.ChildService;

public class ChildServiceImpl implements ChildService {

    private final ChildRepository childRepository;

    public ChildServiceImpl() {
//        this.childRepository = new ChildRepositoryImpl();
        this.childRepository = new ChildMyBatisImpl();
    }

    @Override
    public Child create(Child child) {
        child.setId(null);
        childRepository.create(child);
        return child;
    }
}
