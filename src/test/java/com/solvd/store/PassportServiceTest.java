package com.solvd.store;

import com.solvd.store.domain.Passport;
import com.solvd.store.service.impl.PassportServiceImpl;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.UUID;

public class PassportServiceTest {

    private final PassportServiceImpl passportService;

    public PassportServiceTest() {
        this.passportService = new PassportServiceImpl();
    }

    @Test
    public void verifyCreatePassportTest() {
        Passport passport = new Passport();
        passport.setNumber("" + UUID.randomUUID());
        passport.setVisa(null);
        passport.setExpireDate(LocalDate.of(2024, 01, 01));
        passportService.create(passport);
        Assert.assertNotNull(passport.getId(), "Passport was not created.");
    }

    @DataProvider(name = "createPassportDataProvider")
    public Object[][] fillPassportFields() {
        Passport passport1 = new Passport();
        passport1.setNumber("" + UUID.randomUUID());
        passport1.setVisa(null);
        passport1.setExpireDate(LocalDate.of(2024, 02, 02));
        Passport passport2 = new Passport();
        passport2.setNumber("" + UUID.randomUUID());
        passport2.setVisa(null);
        passport2.setExpireDate(LocalDate.of(2024, 03, 03));
        Passport passport3 = new Passport();
        passport3.setNumber("" + UUID.randomUUID());
        passport3.setVisa(null);
        passport3.setExpireDate(LocalDate.of(2024, 04, 04));
        Passport passport4 = new Passport();
        passport4.setNumber("" + UUID.randomUUID());
        passport4.setVisa(null);
        passport4.setExpireDate(LocalDate.of(2024, 05, 05));
        return new Object[][]{{passport1}, {passport2}, {passport3}, {passport4}};
    }

    @Test(dataProvider = "createPassportDataProvider")
    public void testPassportCreateDataProvider(Passport dataProviderPassport) {
        Passport testPassport = passportService.create(dataProviderPassport);
        Long testId = testPassport.getId();
        Assert.assertNotNull(testId, "Passport wasn't created");
    }
}
