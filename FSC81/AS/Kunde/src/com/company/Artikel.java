package com.company;

abstract class Artikel {

    private String bezeichnung;
    private double preis;
    private int artikelnummer;

    /**
     * Artikel dsdaf
     * @param bezeichnung
     * @param preis
     * @param artikelnummer
     */
    public Artikel(String bezeichnung, double preis, int artikelnummer) {
        this.bezeichnung = bezeichnung;
        this.preis = preis;
        this.artikelnummer = artikelnummer;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public double getPreis() {
        return preis;
    }

    public int getArtikelnummer() {
        return artikelnummer;
    }


}
