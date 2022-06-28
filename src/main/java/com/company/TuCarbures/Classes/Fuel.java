package com.company.TuCarbures.Classes;

public class Fuel {
    public  String id;
    public  String fuelName;
    public double price;
    public String date;
    public String heure;
    public String europeanCode;
    public boolean isAvailable = true;

    public Fuel(String id, String fuelName, double price, String date, String heure, String europeanCode, boolean isAvailable) {
        this.id = id;
        this.fuelName = fuelName;
        this.price = price;
        this.date = date;
        this.heure = heure;
        this.europeanCode = europeanCode;
        this.isAvailable = isAvailable;
    }
}