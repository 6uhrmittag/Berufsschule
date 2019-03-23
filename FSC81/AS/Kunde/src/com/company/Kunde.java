package com.company;

public class Kunde implements Comparable {

    // Anfang Attribute
    private String name;
    private static int letzteNummer = 0;
    private int nummer;
    // Ende Attribute

    public Kunde(String name) {
        this.name = name;
        this.nummer = 0;
    }

    // Anfang Methoden
    public String getName() {
        return name;
    }

    public void setName(String nameNeu) {
        name = nameNeu;
    }

    public int getNummer() {
        return nummer;
    }

    @Override // Annotation: die folgende Methode implementiert Comparable
    public int compareTo(Object o){
        Kunde a = (Kunde) o; // Typumwandlung Object-> Artikel
        return name.compareTo(a.name); // compareTo der Klasse String
    }


    // Ende Methoden
} // end of Kunde
