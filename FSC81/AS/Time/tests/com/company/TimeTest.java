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
public class TimeTest {

    @Test
    public void initEmpty() {
        Time zeit = new Time();
        assertThat(zeit.toString(), is(equalTo("00:00:00")));
    }

    @Test
    public void initFull() {
        Time zeit = new Time(23, 12, 1);
        assertThat(zeit.toString(), is(equalTo("23:12:01")));
    }

    @Test
    public void getH() {
        Time zeit = new Time();
        assertThat(zeit.getH(), is(equalTo(0)));
    }

    @Test
    public void getM() {
        Time zeit = new Time();
        assertThat(zeit.getM(), is(equalTo(0)));
    }

    @Test
    public void getS() {
        Time zeit = new Time();
        assertThat(zeit.getS(), is(equalTo(0)));
    }

    @Test
    public void setzeH() {
        Time zeit = new Time();
        zeit.setH(5);
        assertThat(zeit.getH(), is(equalTo(5)));
    }

    @Test
    public void setzeM() {
        Time zeit = new Time();
        zeit.setM(5);
        assertThat(zeit.getM(), is(equalTo(5)));
    }

    @Test
    public void setzeS() {
        Time zeit = new Time();
        zeit.setS(5);
        assertThat(zeit.getS(), is(equalTo(5)));
    }

    @Theory
    public void SetzeHnotValid(
            @TestedOn(ints = {-1, 24, 25}) int input
    ) {
        Time zeit = new Time();
        zeit.setH(input);
        assertThat(zeit.getH(), is(equalTo(-1)));
    }

    @Theory
    public void SetzeMnotValid(
            @TestedOn(ints = {-1, 60, 61}) int input
    ) {
        Time zeit = new Time();
        zeit.setM(input);
        assertThat(zeit.getM(), is(equalTo(-1)));
    }

    @Theory
    public void SetzeSnotValid(
            @TestedOn(ints = {-1, 60, 61}) int input
    ) {
        Time zeit = new Time();
        zeit.setS(input);
        assertThat(zeit.getS(), is(equalTo(-1)));
    }

    @Test
    public void ToString() {
        Time zeit = new Time(1, 1, 1);
        assertThat(zeit.toString(), is(equalTo("01:01:01")));
    }

    @Theory
    public void ValidString(
            @TestedOn(ints = {-1, 24, 60}) int input
    ) {
        Time zeit = new Time(input, 0, 0);
        assertThat(zeit.toString(), is(equalTo("-1")));
    }

    @Theory
    public void ValidSingleTrue(
            @TestedOn(ints = {0, 5, 23}) int stunden
    ) {
        Time zeit = new Time(stunden, 0, 0);
        assertThat(zeit.isValid(), is(true));
    }

    @Theory
    public void ValidSingleFalse(
            @TestedOn(ints = {-1, 24, 60}) int stunden
    ) {
        Time zeit = new Time(stunden, 0, 0);
        assertThat(zeit.isValid(), is(false));
    }

    @Test
    public void duration() {
        Time testzeit1 = new Time(1, 1, 1);
        Time testzeit2 = new Time(2, 2, 2);

        Time differenz = new Time().duration(testzeit1);
        assertThat(differenz.toString(), is(equalTo("01:01:01")));
    }

    @Test
    public void tickSekunde() {
        Time zeit = new Time(1, 1, 1);
        zeit.tick();
        assertThat(zeit.toString(), is(equalTo("01:01:02")));
    }

    @Test
    public void tickMinute() {
        Time zeit = new Time(1, 1, 59);
        zeit.tick();
        assertThat(zeit.toString(), is(equalTo("01:02:00")));
    }

    @Test
    public void tickStunde() {
        Time zeit = new Time(1, 59, 59);
        zeit.tick();
        assertThat(zeit.toString(), is(equalTo("02:00:00")));
    }

    @Test
    public void tickTag() {
        Time zeit = new Time(23, 59, 59);
        zeit.tick();
        assertThat(zeit.toString(), is(equalTo("00:00:00")));
    }
}