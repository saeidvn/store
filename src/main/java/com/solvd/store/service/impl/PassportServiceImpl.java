package com.solvd.store.service.impl;

import com.solvd.store.domain.Passport;
import com.solvd.store.persistence.impl.PassportRepositoryImpl;
import com.solvd.store.service.IPassportService;

public class PassportServiceImpl implements IPassportService {

    private final PassportRepositoryImpl passportRepository;

    public PassportServiceImpl() {
        this.passportRepository = new PassportRepositoryImpl();
    }

    @Override
    public Passport create(Passport passport) {
        passport.setId(null);
        passportRepository.create(passport);
        return passport;
    }
}
