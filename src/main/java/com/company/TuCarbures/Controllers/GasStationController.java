package com.company.TuCarbures.Controllers;


import com.company.TuCarbures.ApiErrors;

import com.company.TuCarbures.Classes.*;

import io.swagger.v3.oas.annotations.Operation;

import com.company.TuCarbures.Repositories.GasStationRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.*;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/StationService")
@CrossOrigin(origins = "*")
@Slf4j
@Tag(name = "historique", description = "gestion des stations services")
public class GasStationController {

    @Autowired
    ServiceGasStation serviceGasStation;

    private ApiErrors apiErrors = new ApiErrors();


    @GetMapping(value = "/Releve/{id}")
    @Operation(
            tags = "Relevé GasStation",
            summary = "relevé de prix de chaque carburant disponible pour une station avec la date",
            parameters = {
                    @Parameter(
                            name = "id",
                            description = "Unique id for search information",
                            required = true
                    )
            },
            responses = {
                    @ApiResponse(responseCode = "200",
                            description = "Successfuly ",
                            content = @Content(schema = @Schema(implementation = GasStation.class))
                    ),
                    @ApiResponse(responseCode = "400",
                            description = "GasStation Not found"),
                    @ApiResponse(responseCode = "500",
                            description = "Error servor "
                    ),
            })
    public  List<FuelAvailable> priceOfFuels(String id) {
        Optional<GasStation> station = serviceGasStation.findGastation(id);
        List<FuelAvailable> result = new ArrayList<>();
        for (Fuel fuel : station.get().getFuels()) {
            if (fuel.isAvailable) {
                String date = fuel.date;
                String fuelName = fuel.getFuelName();
                Double price = fuel.getPrice();
                result.add(new FuelAvailable(fuelName, price, date));
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
        serviceGasStation.saveGasStation(gasStation);

        return ResponseEntity.ok(gasStation.id);
    }


    @GetMapping("/{id}")
    @Operation(summary = "Retourner une station ")
    public Optional<GasStation> getStation(@PathVariable("id") String id) {
        return serviceGasStation.findGastation(id);
    }


    @GetMapping("/marque")
    @Operation(summary = "Les marques de stations service")
    public HashMap<String, String> brandOfStation() {
        Iterable<GasStation> station = gasStationRepository.findAll();
        HashMap<String, String> brandGas = new HashMap<String, String>();
        for (GasStation gasStation : station) {
            String stationName = gasStation.gasStationName;
            String brandName = gasStation.brand;

            brandGas.put(stationName, brandName);
        }

        return brandGas;

    @GetMapping("/StationsServices")
    @Operation(summary = "Les stations service : marque, adresse postale, coordonnées géographiques")
    public List<GasStationRequest> getAllStations() {

        List<GasStation> result = new ArrayList<>();
        Iterable<GasStation> stations = serviceGasStation.findAllStation();
        stations.forEach(result::add);


//      List<GasStation> result2 = Lists.newArrayList(stations);

        List<GasStationRequest> resultFinal = new ArrayList<>();

        for (int i = 0; i < result.size(); i++) {
            String id = result.get(i).id;
            String brand = result.get(i).brand;
            String adress = result.get(i).adress;
            Long zipcode = result.get(i).zipcode;
            String city = result.get(i).city;
            float latitude = result.get(i).latitude;
            float longitude = result.get(i).longitude;

            resultFinal.add(new GasStationRequest(id,brand, adress, zipcode, city, latitude, longitude));
        }
        return resultFinal;
    }

    @GetMapping("/Releves")
    @Operation(summary = "Les relevés : carburant, station, date, heure, prix constaté à la pompe")
    public List<FuelRequest> getAllStationsStatement() {
        List<FuelRequest> resultFinal = new ArrayList<>();
        List<GasStation> result = new ArrayList<>();
        Iterable<GasStation> stations = serviceGasStation.findAllStation();
        stations.forEach(result::add);

        for (int i = 0; i < result.size(); i++) {
            String gasStationName = result.get(i).gasStationName;
            List<Fuel> fuels = result.get(i).fuels;
            for (int y = 0; y < fuels.size(); y++) {
                String fuelName = fuels.get(y).getFuelName();
                double price = fuels.get(y).getPrice();
                String date = fuels.get(y).date;
                String heure = fuels.get(y).heure;
                resultFinal.add(new FuelRequest(gasStationName, fuelName, price, date, heure));
            }

        }
        return resultFinal;

    }
}
