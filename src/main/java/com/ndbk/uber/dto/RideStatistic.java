package com.ndbk.uber.dto;

public class RideStatistic {
    private String city;
    private long anzahl;
    private double umsatz;
    private double avgLat;
    private double avgLong;

    public RideStatistic(String city, long anzahl, double umsatz, double avgLat, double avgLong) {
        this.city = city;
        this.anzahl = anzahl;
        this.umsatz = umsatz;
        this.avgLat = avgLat;
        this.avgLong = avgLong;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(long anzahl) {
        this.anzahl = anzahl;
    }

    public double getUmsatz() {
        return umsatz;
    }

    public void setUmsatz(double umsatz) {
        this.umsatz = umsatz;
    }

    public double getAvgLat() {
        return avgLat;
    }

    public void setAvgLat(double avgLat) {
        this.avgLat = avgLat;
    }

    public double getAvgLong() {
        return avgLong;
    }

    public void setAvgLong(double avgLong) {
        this.avgLong = avgLong;
    }
}

