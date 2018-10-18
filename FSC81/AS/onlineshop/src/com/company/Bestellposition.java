package com.company;

public class Bestellposition {
    private Integer anzahl;

    public Artikel getArtikel() {
        return artikel;
    }

    private Artikel artikel;

    public Bestellposition(Artikel artikel, Integer anzahl) {
        this.anzahl = anzahl;
        this.artikel = artikel;
    }
}
