package com.company.TuCarbures.Classes;

public class FuelDto {
    public String gasStationName;
    public String fuelName;
    public Double price;
    public String date;
    public String heure;

    public FuelDto(String gasStationName, String fuelName, Double price, String date, String heure){

        this.gasStationName = gasStationName;
        this.fuelName = fuelName;
        this.price = price;
        this.date = date;
        this.heure = heure;
    }
}