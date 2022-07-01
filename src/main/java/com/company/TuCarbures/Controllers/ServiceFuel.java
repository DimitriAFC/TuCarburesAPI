package com.company.TuCarbures.Controllers;

import com.company.TuCarbures.Classes.Fuel;
import com.company.TuCarbures.Classes.GasStation;
import com.company.TuCarbures.Repositories.FuelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceFuel {

    @Autowired
    FuelRepository fuelRepository;

    public Optional<Fuel> findFuel(String id){
        return fuelRepository.findById(id);
    }

    public Iterable<Fuel> findAllFuel(){
        return fuelRepository.findAll();
    }

    public Fuel saveFuel(Fuel fuel){
        return fuelRepository.save(fuel);
    }

    public void setPriceOfList(List<Fuel> fuels, String id, Double price){
        for (Fuel fuel : fuels){
            if(fuel.getId().equals(id)){
                fuel.setDate("01/07/2022");
                fuel.setId(id);
                fuel.setHeure("11:00");
                fuel.setAvailable(true);
                fuel.setEuropeanCode(fuel.getEuropeanCode());
                fuel.setFuelName(fuel.getFuelName());
                fuel.setPrice(price);
                saveFuel(fuel);
            }
        }
    }
}
