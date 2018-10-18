package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here

        // Liste mit Kunden
        System.out.println("Liste mit Kunden:");
        ArrayList<Kunde> kunden = new ArrayList<>();
        kunden.add(new Kunde("hans"));
        kunden.add(new Kunde("tom"));
        kunden.add(new Kunde("karl"));

        for(int i = 0;i < kunden.size();i++){
            System.out.println(kunden.get(i).getName() + " " + kunden.get(i).getNummer());
        }
        System.out.println("\n");
        //Liste mit Kunden Ende

        // Liste mit Artikeln
        System.out.println("Liste mit Artikeln:");
        ArrayList<Artikel> artikel = new ArrayList<>();
        artikel.add(new Artikel("Tomate", 0.4));
        artikel.add(new Artikel("Mango", 3.2));
        artikel.add(new Artikel("Luft", 1.5));

        for(int i = 0;i < artikel.size();i++){
            System.out.println(artikel.get(i).getBezeichnung() + " " + artikel.get(i).getNummer()+ " " + artikel.get(i).getPreis() );
        }
        System.out.println("\n");
        //Liste mit Artikeln Ende




        // Liste mit Bestellungen
        System.out.println("Liste mit Bestellungen:");
        ArrayList<Bestellung> bestellungen = new ArrayList<>();

        for(int i = 0;i < kunden.size();i++) {
            bestellungen.add(new Bestellung(kunden.get(i)));
        }

        for(int i = 0;i < bestellungen.size();i++) {
            System.out.println(bestellungen.get(i).getDatum() + " " + bestellungen.get(i).getKunde().getName());
        }
        System.out.println("\n");
        //Liste mit Bestellungen Ende


        //Erzeuge Bestellungen für Kunden 1
        System.out.println("Liste mit Positionen für Kunde 1:");
        bestellungen.get(1).addPosition(artikel.get(1), 4);

        for(Integer i = 0; i < bestellungen.size(); i++){
            System.out.println("Bestellungen von: " + bestellungen.get(i).getKunde().getName());

            for(Integer b = 0; b < bestellungen.get(i).getBestellposition().size();b++){
                System.out.println("\tPositionen: " + bestellungen.get(i).getBestellposition().get(b).getArtikel().getBezeichnung());

            }

        }





    }
}
