package com.company;

//Datei: Datum.java
class Datum {
    private int tag, monat, jahr;

    public Datum() {
    }

    //Ergänzen Sie die Zugriffsmethoden (get/set –Methoden) für Monat und Jahr
    public Datum(int tag, int monat, int jahr) {
        setTag(tag);
        setMonat(monat);
        setJahr(jahr);
    }

    //Ergänzen Sie einen weiteren Konstruktor, der als Parameter day, month und year besitzt.


    //Ergänzen Sie die Zugriffsmethoden (get/set –Methoden) für Monat und Jahr
    public int getTag() {
        return tag;
    }

    public int getMonat() {
        return monat;
    }

    public int getJahr() {
        return jahr;
    }


    //Ergänzen Sie die Methode public boolean valid().
    //Die Methode gibt false zurück, wenn Tag, Monat oder Jahr den Wert 0 besitzen,
    //andernfalls gibt die Methode true zurück.
    public boolean valid() {
        if ((this.jahr == 0) || (this.monat == 0) || (this.tag == 0)) {
            return false;
        } else {
            return true;
        }
    }


    //Ergänzen Sie Plausibilitätsprüfungen in den Set-Methoden für Tag und Monat.
    //Tag muss zwischen 1 – 31 sein. Monat zwischen 1-12.
    //Falls die Prüfung nicht bestanden wird, soll der Wert auf 0 gesetzt werden.
    public void setTag(int tag) {
        if (tag >= 0 && tag <= 31) {
            this.tag = tag;
        } else {
            this.tag = 0;
        }
    }

    public void setMonat(int monat) {
        if (monat >= 0 && monat <= 12) {
            this.monat = monat;
        } else {
            this.monat = 0;
        }
    }

    public void setJahr(int jahr) {
        this.jahr = jahr;
    }

    //print nice format
    public String nice(){
        String output = "";
        output = String.valueOf(this.tag) + '.' + String.valueOf(this.monat) + '.' + String.valueOf(this.jahr);
        return output;
    }

    //Die Methode gibt das Datum des nächsten Tages zurück. Das originale Datum wird nicht
    //verändert.
    public Datum nextDay(){
        Datum nextDatum = new Datum();


        if (this.tag == 31 && this.monat != 12){
            nextDatum.setTag(1);
            nextDatum.setMonat(this.monat + 1);
        }else{
            nextDatum.setTag(this.tag + 1);
            nextDatum.setMonat(this.monat);
        }

        if (this.monat == 12 && this.tag == 31){
            nextDatum.setJahr(this.jahr + 1);
            nextDatum.setTag(1);
            nextDatum.setMonat(1);
        }else{
            nextDatum.setJahr(this.jahr);
        }


        return nextDatum;
    }
}


