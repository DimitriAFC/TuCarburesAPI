package com.company.TuCarbures.Classes;

public class Fuel {

    public  String id;
    public String fuelName;
    public Double price;
    public String date;
    public String heure;
    public String europeanCode;
    public boolean isAvailable = true;

    public Fuel(String id, String fuelName, double price, String date, String heure, String europeanCode, boolean isAvailable) {
        this.id = id;
        this.setFuelName(fuelName);
        this.setPrice(price);
        this.date = date;
        this.heure = heure;
        this.europeanCode = europeanCode;
        this.isAvailable = isAvailable;
    }

    public String getFuelName() {
        return fuelName;
    }

    public void setFuelName(String fuelName) {
        this.fuelName = fuelName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}