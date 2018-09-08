package com.company;


public class Main {

    public static void main(String[] args) {

        Address adresse = new Address();

        Address neueaddresse = new Address("straße", "5", "1234f5", "Unna");

        adresse.setCity("Unna");

        System.out.println(adresse.getCity());

        System.out.println(neueaddresse.getCity() + neueaddresse.getZip() + neueaddresse.getStreet() + neueaddresse.getNumber());


    }

}