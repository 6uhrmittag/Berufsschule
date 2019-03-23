package com.company;

public class Girokonto extends Konto {

    private Double dispo = 0.0;
    private Double dispozinz = 0.0;

    public Double getDispozinz() {
        return dispozinz;
    }

    public Double getDispo() {
        return dispo;
    }

    public Girokonto(String iban, Kunde inhaber) {
        super(iban, inhaber);
    }

    @Override
    public boolean transaktion(double betrag) {
        //darf bis dispo negativ werden
        if ((this.kontostand + betrag) >= this.dispo) {
            this.kontostand += betrag;
            return true;
        } else {
            System.out.println("Transaktion konnte nicht durchgeführt werden.");
            return false;
        }
    }
}
