package com.company;

class Address {

    // Alle Membervariablen von Address sind vom Typ String.
    // Folgende Member sollen enthalten sein: Street + Number, ZIP, City.
    private String street, number, zip, city;

    public Address() {
    }

    public Address(String street, String number, String zip, String city) {
        setStreet(street);
        setNumber(number);
        setZip(zip);
        setCity(city);
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    // In setZip(String zip) wird geprüft ob zip genau 5 Zeichen besitzt, falls nicht, wird zip auf null gesetzt.
    public void setZip(String zip) {
        if (zip.length() == 5) {
            this.zip = zip;
        } else {
            this.zip = null;
        }
    }


    public void setCity(String city) {
        this.city = city;
    }

    public String getCity(){return city;}
    public String getNumber(){return number;}
    public String getStreet(){return street;}
    public String getZip(){return zip;}


// Die Klasse enthält einen Default-Konstruktor und die Zugriffsmethoden.


}


