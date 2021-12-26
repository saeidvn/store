package com.solvd.store.service;

import com.solvd.store.domain.Passport;

import java.time.LocalDate;

public interface PassportService {

    Passport create (Passport passport);

    void update (Passport passport);

    Passport get(LocalDate expireDate);
}