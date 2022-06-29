package com.company.TuCarbures.Classes;

import java.util.List;

public class GasStationRequest {


    public String brand;
    public String adress;
    public Long zipcode;
    public String city;
    public float longitude;
    public float latitude;


        public GasStationRequest(String brand, String adress, Long zipcode, String city,
                                    float longitude, float latitude){
        this.brand = brand;
        this.adress = adress;
        this.zipcode = zipcode;
        this.city = city;
        this.longitude = longitude;
        this.latitude = latitude;
    }
}