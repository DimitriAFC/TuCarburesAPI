package com.company.TuCarbures.Controllers;


import com.company.TuCarbures.ApiErrors;

import com.company.TuCarbures.Classes.Fuel;
import io.swagger.v3.oas.annotations.Operation;

import com.company.TuCarbures.Classes.GasStation;
import com.company.TuCarbures.Repositories.GasStationRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(path = "/StationService")
@CrossOrigin(origins = "*")
@Slf4j
@Tag(name = "historique", description = "gestion des stations services")
public class GasStationController {

    @Autowired
    GasStationRepository gasStationRepository;

    private ApiErrors apiErrors = new ApiErrors();

    //Fournir le dernier relevé de prix de chaque carburant disponible avec la date du
    //relevé pour une station service donnée (pour l’affichage de la station favorite)

    @GetMapping(value = "/Releve/{id}")
    @Operation(summary = "relevé de prix de chaque carburant pour une station")
    public HashMap<String, Double> priceOfFuels(@PathVariable("id") String id){
        Optional<GasStation> station = gasStationRepository.findById(id);

        HashMap<String, Double> fuelPrice = new HashMap<String,Double>();
        for (Fuel fuel : station.get().getFuels()) {
            String fuelName = fuel.getFuelName();
            Double price = fuel.getPrice();

            fuelPrice.put(fuelName,price);
        }

        return fuelPrice;
    }

    @PostMapping(value = "/StationService")
    @Operation(summary = "ajouter une station, avec les carburants : Sans Plomb 98 (E5)\n" +
            "- Sans Plomb 95 (E5)\n" +
            "- Sans Plomb 95 (E10)\n" +
            "- Superéthanol E85\n" +
            "- Gazole (B7)\n" +
            "- GPL ")
    public ResponseEntity<String> postGasStation(@RequestBody GasStation gasStation) {

        if(gasStation.gasStationName.equals("string") || gasStation.id.equals("string")) {
            apiErrors.addError("404", "la station est vide");
            return ResponseEntity.badRequest().body("la station n'est pas correct");
        }
        gasStationRepository.save(gasStation);

       return ResponseEntity.ok(gasStation.id);
    }


    @GetMapping("StationService/{id}")
    @Operation(summary = "Retourner une station avec ses carburants")
    public Optional<GasStation> getStation(@PathVariable("id") String id) {
        return gasStationRepository.findById(id);
    }

}
