package com.company.TuCarbures.Controllers;

import com.company.TuCarbures.Classes.Fuel;
import com.company.TuCarbures.Classes.GasStation;
import com.company.TuCarbures.Repositories.FuelRepository;
import com.company.TuCarbures.Repositories.GasStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceGasStation {

    @Autowired
    FuelRepository fuelRepository;

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


    public List<Optional> filterFuel(List<GasStation> stations, String nom, String code) {
        List<Optional> result = new ArrayList<>();
        for (int i = 0; i < stations.size(); i++) {
            String fuelName = stations.get(i).getFuels().get(i).fuelName;
            String europeanCode = stations.get(i).getFuels().get(i).europeanCode;
            if(fuelName.equals(nom) && europeanCode.equals(code)){
                String id= stations.get(i).id;
                Optional<Fuel> byId = fuelRepository.findById(id);
                result.add(byId);
            }
        }
        return result;
    }
}
