package com.company;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {


        ArrayList<Kunde> kunde = new ArrayList<Kunde>();
        kunde.add(new Kunde("aname"));
        kunde.add(new Kunde("cname"));
        kunde.add(new Kunde("bname"));
        kunde.add(new Kunde("dname"));

        System.out.println("Unsortiert:");
        for (int i = 0; i <= 3; i++) {
            System.out.println(kunde.get(i).getName());
        }

        java.util.Collections.sort(kunde);

        System.out.println("Sortiert:");

        for (int i = 0; i <= 3; i++) {
            System.out.println(kunde.get(i).getName());
        }

        // Konten

        Sparkonto konto = new Sparkonto("sfde3y", kunde.get(0));
        System.out.println("Iban inhaber1: " + konto.getIban());

        Sparkonto sparkonto1 = new Sparkonto("y3283e", kunde.get(1));
        System.out.println("Sparkonto Kunde 1 :" + " Kontostand: " + sparkonto1.getKontostand());
        sparkonto1.transaktion(-5);
        System.out.println("Sparkonto Kunde 1 :" + " Kontostand: " + sparkonto1.getKontostand());


        Girokonto girokonto1 = new Girokonto("y3283e", kunde.get(2));
        System.out.println("Griokonto Kunde 2 :" + " Kontostand: " + girokonto1.getKontostand());
        girokonto1.transaktion(-5);
        System.out.println("Griokonto Kunde 2 :" + " Kontostand: " + girokonto1.getKontostand());


        ArrayList<Konto> konten = new ArrayList<>();
        konten.add(new Sparkonto("DDF333", kunde.get(1)));
        konten.add(new Sparkonto("CDF", kunde.get(2)));
        konten.add(new Sparkonto("AAB1", kunde.get(0)));
        konten.add(new Girokonto("B12", kunde.get(1)));

        for (Integer i = 0; i <= 3; i++) {
            System.out.println(konten.get(i).getIban());
        }


        java.util.Collections.sort(konten);

        for (Integer i = 0; i <= 3; i++) {
            System.out.println(konten.get(i).getIban());
        }


        ArrayList<Artikel> artikel = new ArrayList<>();
        artikel.add(new Lebensmittel("Milka", 1.40, 8349302));

        System.out.println(artikel.get(0).getBezeichnung() + " " + artikel.get(0).getPreis() + " " + artikel.get(0).getArtikelnummer());

        if (artikel.get(0).getClass() == Lebensmittel.class) {
            Lebensmittel banane = ((Lebensmittel) artikel.get(0));
            System.out.println(banane.getMhd());
            banane.setMhd(LocalDate.now().plusWeeks(1));
            System.out.println(banane.getMhd());
        }


        //System.out.println(artikel.get(0).getBezeichnung() + " " + artikel.get(0).getPreis());


    }


}
