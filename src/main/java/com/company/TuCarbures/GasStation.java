package com.company.TuCarbures;

import java.util.List;

public class GasStation {
    public String id;
    private String gasStationName;
    private String brand;
    private String adress;
    private Long zipcode;
    private String city;
    private Long longitude;
    private Long latitude;
    private List<Fuel> fuels;

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

}
