package com.company.TuCarbures.Classes;

import java.util.ArrayList;
import java.util.List;

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
    public static List<FuelDto> convertToListFuel(List<GasStation> gasStationList){
        List<FuelDto> resultFinal = new ArrayList<>();

        for (int i = 0; i < gasStationList.size(); i++) {
            String gasStationName = gasStationList.get(i).gasStationName;
            List<Fuel> fuels = gasStationList.get(i).fuels;

            for (int y = 0; y < fuels.size(); y++) {
                String fuelName = fuels.get(y).getFuelName();
                double price = fuels.get(y).getPrice();
                String date = fuels.get(y).date;
                String heure = fuels.get(y).heure;
                resultFinal.add(new FuelDto(gasStationName, fuelName, price, date, heure));
            }

        }
        return resultFinal;
    }
}
