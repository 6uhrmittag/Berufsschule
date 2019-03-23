package com.company;


import jdk.jfr.Description;
import jdk.jfr.Name;

import org.junit.Test;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

@RunWith(Theories.class)
public class LebensmittelTest {

    @Test
    public void Bezeichnung() {
        Artikel banane = new Lebensmittel("banane", 1.50, 815);
        assertThat(banane.getBezeichnung(), is(equalTo("banane")));

    }

    @Test
    public void getPreis() {
        Artikel banane = new Lebensmittel("banane", 1.50, 815);
        assertThat(banane.getPreis(), is(equalTo(1.50)));

    }

    @Test
    public void getArtikelnummer() {
        Artikel banane = new Lebensmittel("banane", 1.50, 815);
        assertThat(banane.getPreis(), is(equalTo(815)));
    }
}