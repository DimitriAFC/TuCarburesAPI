package com.company.TuCarbures.Controllers;

import com.company.TuCarbures.Classes.GasStation;
import com.company.TuCarbures.Repositories.GasStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceGasStation {

    @Autowired
    GasStationRepository gasStationRepository;

    public Optional<GasStation> findGastation(String id){
        return gasStationRepository.findById(id);
    }

    public Iterable<GasStation> findAllStation(){
        return gasStationRepository.findAll();
    }

    public GasStation saveGasStation(GasStation gasStation) {
        return gasStationRepository.save(gasStation);
    }
    public HashMap<String,String> convertListToHasMap(Iterable<GasStation> gasStationList){
        HashMap<String, String> brandGas = new HashMap<>();
        for (GasStation gasStation : gasStationList) {
            String stationName = gasStation.gasStationName;
            String brandName = gasStation.brand;
            brandGas.put(stationName, brandName);
        }
        return brandGas;
    }
}
