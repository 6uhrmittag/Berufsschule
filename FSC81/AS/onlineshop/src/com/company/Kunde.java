package com.company;

import java.util.ArrayList;
import java.util.Random;


public class Kunde {
    private String name;

    public Integer getNummer() {
        return nummer;
    }

    private Integer nummer;

    /**
     * Erzeugt neuen Kunden
     *
     * @param name
     */
    public Kunde(String name) {
        this.name = name;
        Random rand = new Random();
        this.nummer = Math.abs(rand.nextInt());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
