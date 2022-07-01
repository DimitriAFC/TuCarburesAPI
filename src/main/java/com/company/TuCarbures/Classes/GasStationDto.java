package com.company.TuCarbures.Classes;

import java.util.ArrayList;
import java.util.List;

public class GasStationDto {

    public String id;
    public String brand;
    public String adress;
    public Long zipcode;
    public String city;
    public float longitude;
    public float latitude;


    public GasStationDto(String id, String brand, String adress, Long zipcode, String city,
                         float longitude, float latitude) {
        this.id = id;
        this.brand = brand;
        this.adress = adress;
        this.zipcode = zipcode;
        this.city = city;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public static List<GasStationDto> convertListToGasStationDto(List<GasStation> gasStationList) {
        List<GasStationDto> resultFinal = new ArrayList<>();

        for (int i = 0; i < gasStationList.size(); i++) {
            String id = gasStationList.get(i).id;
            String brand = gasStationList.get(i).brand;
            String adress = gasStationList.get(i).adress;
            Long zipcode = gasStationList.get(i).zipcode;
            String city = gasStationList.get(i).city;
            float latitude = gasStationList.get(i).latitude;
            float longitude = gasStationList.get(i).longitude;

            resultFinal.add(new GasStationDto(id, brand, adress, zipcode, city, latitude, longitude));
        }
        return resultFinal;
    }
}
