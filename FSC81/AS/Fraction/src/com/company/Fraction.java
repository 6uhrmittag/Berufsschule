package com.company;

//Ergänzen Sie die Methode zum Multiplizieren (mul).
//Ergänzen Sie die Methode public String toString().
//Diese gibt den Bruch als Zeichenkette in folgendem Format zurück: „nomi/denomi“


//Ergänzen Sie eine Methode zum Kürzen des Bruchs.
//Ergänzen Sie Methoden zum Addieren und Subtrahieren.
//Gestalten Sie die Eingabe von Brüchen komfortabler, in dem die Eingabe eines
//Bruchs als Zeichenkette erfolgt („Zähler/Nenner“).


public class Fraction { // Bruch

    private int nomi, denomi; // Zähler, Nenner

    public Fraction(int nomi, int denomi){

        this.nomi = nomi;
        if (denomi == 0) { // 0 für Nenner verboten, Bruch auf 0 setzen.
            this.denomi=1;
            this.nomi = 0;
        }
        else {
            this.denomi = denomi;
        }

    }

    public int getNominator() {return nomi;}
    public int getDenominator() {return denomi;}
    public Fraction div(Fraction frac) {
        return new Fraction(nomi* frac.denomi, denomi*frac.nomi);
    }
}