package com.pt2.myapplication;

public class Produkt {
    private String nazwa;
    private double cena;
    private String opis;
    private boolean dostepny;

    public Produkt(String nazwa, String opis, double cena) {
        this.nazwa = nazwa;
        this.opis = opis;
        this.cena = cena;
    }


    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    @Override
    public String toString() {
        return nazwa + "\n" + cena + "\n" + opis;
    }
}
