package com.solvd.store.persistence;

import com.solvd.store.domain.Passport;

import java.time.LocalDate;

public interface PassportRepository {

    void create(Passport passport);

    void update(Passport passport);

    Passport get(LocalDate expireDate);
}
