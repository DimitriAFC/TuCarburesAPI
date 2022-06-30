package com.company.TuCarbures.Controllers;

import com.company.TuCarbures.Classes.Fuel;
import com.company.TuCarbures.Classes.GasStation;
import com.company.TuCarbures.Repositories.FuelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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


}
