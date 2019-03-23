package com.company;

import org.junit.Test;
import org.junit.experimental.theories.Theory;
import org.junit.experimental.theories.suppliers.TestedOn;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SparkontoTest {

    @Theory
    public void transaction(
            @TestedOn(ints = {-1, 24, 60}) int geld
    ) {

        Kunde kunde = new Kunde("hans");

        Sparkonto konto = new Sparkonto("dfd4", kunde);
        assertThat(konto.getKontostand(), is(equalTo(0.0)));

        konto.transaktion(5);
        assertThat(konto.getKontostand(), is(equalTo(5)));

        assertThat(konto.transaktion(-5), is(false));

    }
}