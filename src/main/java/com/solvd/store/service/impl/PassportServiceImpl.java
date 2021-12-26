package com.solvd.store.service.impl;

import com.solvd.store.domain.Passport;
import com.solvd.store.domain.exeption.ProcessingException;
import com.solvd.store.persistence.PassportRepository;
import com.solvd.store.persistence.impl.PassportMyBatisImpl;
import com.solvd.store.service.PassportService;

import java.time.LocalDate;

public class PassportServiceImpl implements PassportService {

    private final PassportRepository passportRepository;

    public PassportServiceImpl() {
//        this.passportRepository = new PassportRepositoryImpl();
        this.passportRepository = new PassportMyBatisImpl();
    }

    @Override
    public Passport create(Passport passport) {
        passport.setId(null);
        passportRepository.create(passport);
        return passport;
    }

    @Override
    public void update(Passport passport) {
        passportRepository.update(passport);
    }

    @Override
    public Passport get(LocalDate expireDate) {
        Passport passport = passportRepository.get(expireDate);
        if(passport == null) {
            throw new ProcessingException("Object not found.");
        }
        return passport;
    }
}
