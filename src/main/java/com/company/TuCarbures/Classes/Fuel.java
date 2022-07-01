package com.company.TuCarbures.Classes;

public class Fuel {

    private String id;
    private String fuelName;
    public Double price;
    private String date;
    private String heure;
    private String europeanCode;
    private boolean isAvailable = true;

    public Fuel(String id, String fuelName, double price, String date, String heure, String europeanCode, boolean isAvailable) {
        this.setId(id);
        this.setFuelName(fuelName);
        this.setPrice(price);
        this.setDate(date);
        this.setHeure(heure);
        this.setEuropeanCode(europeanCode);
        this.setAvailable(isAvailable);
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public String getEuropeanCode() {
        return europeanCode;
    }

    public void setEuropeanCode(String europeanCode) {
        this.europeanCode = europeanCode;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}