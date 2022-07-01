package com.company.TuCarbures.Classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FuelAvailableDto {
    public String fuelName;
    public Double price;
    public String date;

    public FuelAvailableDto(String fuelName, Double price, String date) {
        this.fuelName = fuelName;
        this.price = price;
        this.date = date;
    }

    public static List<FuelAvailableDto> convertOptionalToList(Optional<GasStation> station) {
        List<FuelAvailableDto> result = new ArrayList<>();
        for (Fuel fuel : station.get().getFuels()) {
            if (fuel.isAvailable()) {
                String date = fuel.getDate();
                String fuelName = fuel.getFuelName();
                Double price = fuel.getPrice();
                result.add(new FuelAvailableDto(fuelName, price, date));
            }
        }
        return result;
    }
}
