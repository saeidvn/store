package com.solvd.store.persistence;

import com.solvd.store.domain.Child;

import java.util.List;

public interface IChildRepository {

    void create (Child child);

    Child create(List<Child> children);
}
