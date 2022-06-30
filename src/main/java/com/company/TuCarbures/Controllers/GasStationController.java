package com.company.TuCarbures.Controllers;


import com.company.TuCarbures.ApiErrors;
import com.company.TuCarbures.Classes.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    private GasStationDto gasStationDto;
    private FuelDto fuelDto;



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


    @GetMapping("/StationsServices")
    @Operation(summary = "Les stations service : marque, adresse postale, coordonnées géographiques")
    public List<GasStationDto> getAllStations() {

        List<GasStation> result = new ArrayList<>();
        Iterable<GasStation> stations = serviceGasStation.findAllStation();
        stations.forEach(result::add);

        return GasStationDto.convertListToGasStationDto(result);
    }

    @GetMapping("/Releves")
    @Operation(summary = "Les relevés : carburant, station, date, heure, prix constaté à la pompe")
    public List<FuelDto> getAllStationsStatement() {

        List<GasStation> result = new ArrayList<>();
        Iterable<GasStation> stations = serviceGasStation.findAllStation();
        stations.forEach(result::add);

        return FuelDto.convertToListFuel(result) ;
    }
}
