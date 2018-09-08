package com.company;

public class Main {

    public static void main(String[] args) {
        // Erzeugen Sie ein Objekt der Klasse Date in der main() Methode
        Datum da = new Datum(); // tag, monat, jahr = 0
        Datum da2 = new Datum(31, 11, 2018);

        System.out.println("da2: " + da2.getJahr()+ "-" + da2.getMonat() + "-" + da2.getTag());
        System.out.println("da2 formatiert: " + da2.nice());
        System.out.println("da2 nächstes datum: " + da2.nextDay().nice());

        System.out.println("da: " + da.getJahr()+ "-" + da.getMonat() + "-" + da.getTag());

        System.out.println("da valid?: " + da.valid());



    }
}
