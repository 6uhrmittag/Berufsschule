package com.company;

public class Time {

    private int h;
    private int m;
    private int s;


    public Time(int h, int m, int s) {
        setH(h);
        setM(m);
        setS(s);
    }

    public Time() {
    }

    public int getH() {
        return h;
    }

    public int getM() {
        return m;
    }

    public int getS() {
        return s;
    }

    public void setH(int h) {
        if (h >= 0 && h < 24) {
            this.h = h;
        } else {
            this.h = -1;
        }
    }


    public void setM(int m) {
        if (m >= 0 && m < 60) {
            this.m = m;
        } else {
            this.m = -1;
        }
    }

    public void setS(int s) {
        if (s >= 0 && s < 60) {
            this.s = s;
        } else {
            this.s = -1;
        }
    }


    public boolean isValid() {
        if (this.h == -1 || this.m == -1 || this.s == -1) {
            return false;
        } else {
            return true;
        }
    }


    public String toString() {
        String formatted;

        if (!this.isValid()) {
            formatted = "-1";
        } else {
            formatted = String.format("%02d:%02d:%02d", this.h, this.m, this.s);
        }

        return formatted;
    }


    public Time duration(Time vergleichszeit){

        int sek_this = this.getS() + (this.getM() * 60) + (this.getH() * 60 * 60);
        int sek_vergleich = vergleichszeit.getS() + (vergleichszeit.getM() * 60) + (vergleichszeit.getH() * 60 * 60);

        int differenz = Math.abs(sek_this - sek_vergleich);

        int rest;
        int h = differenz /3600;
        rest = differenz % 3600;
        int m = rest / 60;
        rest = rest % 60;
        int s = rest;

        Time differenzTime = new Time(h,m,s);

        return differenzTime;
    }

    public void tick() {

        //setze sekunden
        //falls sek == 59, minute +1
        if (getS() == 59) {
            this.s = 0;
            // falls minute == 59, stunde +1
            if (this.m == 59) {
                this.m = 0;

                //falls stunden == 23, stunden = 0 und exit oder h+1
                if (this.h == 23) {
                    this.h = 0;
                    return;
                } else {
                    this.h = this.h + 1;
                }
            } else {
                this.m = this.m + 1;
            }
        } else {
            this.s = this.s + 1;
        }
        //setze stunden
    }
}
