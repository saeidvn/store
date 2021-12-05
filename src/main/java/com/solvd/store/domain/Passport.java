package com.solvd.store.domain;

import java.sql.Date;
import java.time.LocalDate;

public class Passport {

    private Long id;
    private String number;
    private LocalDate expireDate;
    private Visa visa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }

    public Visa getVisa() {
        return visa;
    }

    public void setVisa(Visa visa) {
        this.visa = visa;
    }
}
