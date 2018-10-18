package com.company;

import java.util.Random;

public class Artikel {
    private String bezeichnung;
    private Double preis;
    private Integer nummer;

    public Artikel(String bezeichnung, Double preis) {
        this.bezeichnung = bezeichnung;
        this.preis = preis;
        Random rand = new Random();
        this.nummer = Math.abs(rand.nextInt());
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public Double getPreis() {
        return preis;
    }

    public Integer getNummer() {
        return nummer;
    }
}
