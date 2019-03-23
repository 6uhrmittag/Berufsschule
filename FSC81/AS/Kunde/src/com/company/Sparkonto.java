package com.company;

public class Sparkonto extends Konto {

    double zinssatz;
    public Sparkonto(String iban, Kunde inhaber){
        super(iban, inhaber);
    }

    @Override
    public boolean transaktion(double betrag){
        //darf nicht null werden
        if((this.kontostand + betrag) >= 0 ){
            this.kontostand += betrag;
            return true;
        }else{
            System.out.println("Transaktion konnte nicht durchgeführt werden.");
            return false;
        }
    }

}
