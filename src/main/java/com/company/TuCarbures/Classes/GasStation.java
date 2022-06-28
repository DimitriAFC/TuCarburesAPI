package com.company.TuCarbures.Classes;

import java.util.List;

public class GasStation {
    public String id;
    public String gasStationName;
    public String brand;
    public String adress;
    public Long zipcode;
    public String city;
    public float longitude;
    public float latitude;
    public List<Fuel> fuels ;

    public GasStation(String id, String gasStationName, String brand, String adress, Long zipcode, String city,
                      Long longitude, Long latitude, List<Fuel> fuels){
        this.id = id;
        this.gasStationName = gasStationName;
        this.brand = brand;
        this.adress = adress;
        this.zipcode = zipcode;
        this.city = city;
        this.longitude = longitude;
        this.latitude = latitude;
        this.fuels = fuels;
    }

    public List<Fuel> getFuels() {
        return fuels;
    }
}
