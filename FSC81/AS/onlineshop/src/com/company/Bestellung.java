package com.company;

import java.time.LocalDate;
import java.util.ArrayList;

public class Bestellung {
    public LocalDate getDatum() {
        return datum;
    }

    private java.time.LocalDate datum;

    public Kunde getKunde() {
        return kunde;
    }

    private Kunde kunde;

    public ArrayList<Bestellposition> getBestellposition() {
        return bestellposition;
    }

    private ArrayList<Bestellposition> bestellposition;

    public Bestellung(Kunde kunde) {
        this.kunde = kunde;
        this.bestellposition = new ArrayList<>();
        this.datum = LocalDate.now();
    }

    public void addPosition(Artikel artikel, Integer anzahl) {
        this.bestellposition.add(new Bestellposition(artikel, anzahl));
    }

    protected void delPosition(Bestellposition bestellposition) {
    }
}
