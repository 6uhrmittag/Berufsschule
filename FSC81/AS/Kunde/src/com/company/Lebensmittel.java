package com.company;

import java.time.LocalDate;

public class Lebensmittel extends Artikel {

    private LocalDate mhd;

    public LocalDate getMhd() {
        return mhd;
    }

    public void setMhd(LocalDate mhd) {
        this.mhd = mhd;
    }

    public Lebensmittel(String bezeichnung, double preis, int artikelnummer) {
        super(bezeichnung, preis, artikelnummer);
        this.setMhd(LocalDate.now().plusYears(1));

    }
}
