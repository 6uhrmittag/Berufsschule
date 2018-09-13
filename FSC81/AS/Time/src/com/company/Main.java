package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Time zeit = new Time();

        System.out.println("Leeres Time Objekt als String: " + zeit.toString());

        zeit = new Time(1,1,1);
        System.out.println("Time Objekt 1,1,1: " + zeit.toString());

        zeit = new Time(12,10,3);
        System.out.println("Time Objekt 12, 10,3 : " + zeit.toString());

        zeit = new Time(14,12,12);
        System.out.println("Is 14,12,12 valid: " + zeit.isValid());

        zeit = new Time(24,12,12);
        System.out.println("Is 24,12,12 valid: " + zeit.isValid());

        zeit = new Time(14,60,12);
        System.out.println("Is 14,60,12 valid: " + zeit.isValid());

        zeit = new Time(14,12,60);
        System.out.println("Is 14,12,60 valid: " + zeit.isValid());

        zeit = new Time(24,61,61);
        System.out.println("Is 24,61,61 valid: " + zeit.isValid());

        zeit = new Time(12,12,12);
        System.out.println("Time Objekt 12,12,12 : " + zeit.toString());

        zeit = new Time(12,12,12);
        zeit.tick();
        System.out.println("Time Objekt 12,12,12 + tick: " + zeit.toString());

        zeit = new Time(12,12,59);
        zeit.tick();
        System.out.println("Time Objekt 12,12,59 + tick: " + zeit.toString());


        zeit = new Time(23,59,59);
        zeit.tick();
        System.out.println("Time Objekt 23,59,59 + tick: " + zeit.toString());

        zeit = new Time(12,0,1);
        Time anderezeit = new Time(13,1,3);
        System.out.println(zeit.duration(anderezeit));



    }
}
