package com.company.TuCarbures.Controllers;


import com.company.TuCarbures.ApiErrors;
import com.company.TuCarbures.Classes.*;
import io.swagger.v3.oas.annotations.Operation;

import com.company.TuCarbures.Repositories.GasStationRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path = "/StationService")
@CrossOrigin(origins = "*")
@Slf4j
@Tag(name = "historique", description = "gestion des stations services")
public class GasStationController<géographiques> {

    @Autowired
    GasStationRepository gasStationRepository;

    private ApiErrors apiErrors = new ApiErrors();


    @GetMapping(value = "/Releve/{id}")
    @Operation(summary = "relevé de prix de chaque carburant disponible pour une station avec la date")
    public List<FuelAvailable> priceOfFuels(@PathVariable("id") String id) {
        Optional<GasStation> station = gasStationRepository.findById(id);
        List<FuelAvailable> result = new ArrayList<>();
        HashMap<String, Double> fuelPrice = new HashMap<String, Double>();
        for (Fuel fuel : station.get().getFuels()) {
            if (fuel.isAvailable) {
                String date = fuel.date;
                String fuelName = fuel.getFuelName();
                Double price = fuel.getPrice();
                result.add(new FuelAvailable(fuelName,price,date));
            }
        }
        return result;
    }

    @PostMapping(value = "/")
    @Operation(summary = "ajouter une station, avec les carburants : Sans Plomb 98 (E5)\n" +
            "- Sans Plomb 95 (E5)\n" +
            "- Sans Plomb 95 (E10)\n" +
            "- Superéthanol E85\n" +
            "- Gazole (B7)\n" +
            "- GPL ")
    public ResponseEntity<String> postGasStation(@RequestBody GasStation gasStation) {

        if (gasStation.gasStationName.equals("string") || gasStation.id.equals("string")) {
            apiErrors.addError("404", "la station est vide");
            return ResponseEntity.badRequest().body("la station n'est pas correct");
        }
        gasStationRepository.save(gasStation);

        return ResponseEntity.ok(gasStation.id);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retourner une station ")
    public Optional<GasStation> getStation(@PathVariable("id") String id) {
        return gasStationRepository.findById(id);
    }


    @GetMapping("/StationsServices")
    @Operation(summary = "Les stations service : marque, adresse postale, coordonnées géographiques")
    public List<GasStationRequest> getAllStations() {

        List<GasStation> result = new ArrayList<>();
        Iterable<GasStation> stations = gasStationRepository.findAll();
        stations.forEach(result::add);
        List<GasStationRequest> resultFinal = new ArrayList<>();

        for (int i = 0; i < result.size(); i++) {
            String brand = result.get(i).brand;
            String adress = result.get(i).adress;
            Long zipcode = result.get(i).zipcode;
            String city = result.get(i).city;
            float latitude = result.get(i).latitude;
            float longitude = result.get(i).longitude;

            resultFinal.add(new GasStationRequest(brand, adress, zipcode, city, latitude, longitude));
        }
        return resultFinal;
    }

    @GetMapping("/Releves")
    @Operation(summary = "Les relevés : carburant, station, date, heure, prix constaté à la pompe")
    public List<FuelRequest> getAllStationsStatement() {
        List<FuelRequest> resultFinal = new ArrayList<>();
        List<GasStation> result = new ArrayList<>();
        Iterable<GasStation> stations = gasStationRepository.findAll();
        stations.forEach(result::add);

        for (int i = 0; i < result.size(); i++) {
            String gasStationName = result.get(i).gasStationName;
            List<Fuel> fuels = result.get(i).fuels;
            for (int y = 0; y < fuels.size(); y++) {
                String fuelName = fuels.get(y).getFuelName();
                double price = fuels.get(y).getPrice();
                String date = fuels.get(y).date;
                String heure = fuels.get(y).heure;
                resultFinal.add(new FuelRequest(gasStationName,fuelName,price,date,heure));
            }

        }
        return resultFinal;
    }
}
