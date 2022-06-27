package com.company.TuCarbures.Classes;

public class Fuel {
    public  String idFuel;
    public  String fuelName;
    public double price;
    public String date;
    public String heure;
    public String europeanCode;

    public Fuel(String idFuel, String fuelName, double price, String date, String heure, String europeanCode) {
        this.idFuel = idFuel;
        this.fuelName = fuelName;
        this.price = price;
        this.date = date;
        this.heure = heure;
        this.europeanCode = europeanCode;
    }
}