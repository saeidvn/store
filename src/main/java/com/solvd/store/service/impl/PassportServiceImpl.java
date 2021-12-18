package com.solvd.store.service.impl;

import com.solvd.store.domain.Passport;
import com.solvd.store.persistence.PassportRepository;
import com.solvd.store.persistence.impl.PassportMyBatisImpl;
import com.solvd.store.persistence.impl.PassportRepositoryImpl;
import com.solvd.store.service.PassportService;

public class PassportServiceImpl implements PassportService {

    private final PassportRepository passportRepository;

    public PassportServiceImpl() {
//        this.passportRepository = new PassportRepositoryImpl();
        this.passportRepository = new PassportMyBatisImpl();
    }

    @Override
    public void create(Passport passport) {
        passport.setId(null);
        passportRepository.create(passport);
    }
}
