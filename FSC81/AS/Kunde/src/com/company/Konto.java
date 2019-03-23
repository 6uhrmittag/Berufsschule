package com.company;

abstract class Konto implements Comparable{

    protected Double kontostand = 0.0;
    private String iban;
    private Kunde inhaber;

    public Konto(String iban, Kunde inhaber){
        this.iban = iban;
        this.inhaber = inhaber;
    };

    public Double getKontostand() {
        return kontostand;
    }

    public String getIban() {
        return iban;
    }

    public Kunde getInhaber() {
        return inhaber;
    }

    @Override
    public int compareTo(Object o){
        Konto a = (Konto) o;
        return iban.compareTo(a.iban);
    }

    public abstract boolean transaktion(double betrag);



}
