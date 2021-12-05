package com.solvd.store.service.impl;

import com.solvd.store.domain.Child;
import com.solvd.store.persistence.impl.ChildRepositoryImpl;
import com.solvd.store.service.IChildService;

public class ChildServiceImpl implements IChildService {

    private final ChildRepositoryImpl childRepository;

    public ChildServiceImpl() {
        this.childRepository = new ChildRepositoryImpl();
    }

    @Override
    public Child create(Child child) {
        child.setId(null);
        childRepository.create(child);
        return child;
    }
}
