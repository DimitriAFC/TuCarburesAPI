package com.company.TuCarbures.Controllers;
import com.company.TuCarbures.ApiError;
import com.company.TuCarbures.ApiErrors;
import com.company.TuCarbures.Classes.Fuel;
import io.swagger.v3.oas.annotations.Operation;
import com.company.TuCarbures.Classes.GasStation;
import com.company.TuCarbures.Repositories.GasStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.util.ObjectUtils.isEmpty;

@RestController
@RequestMapping(path = "/StationService")
@CrossOrigin(origins = "*")
@Slf4j
@Tag(name = "historique", description = "gestion des stations services")
public class GasStationController {

    @Autowired
    GasStationRepository gasStationRepository;

    private ApiErrors apiErrors = new ApiErrors();

    @PostMapping(value = "/StationService")
    @Operation(summary = "ajouter une station, avec les carburants : Sans Plomb 98 (E5)\n" +
            "- Sans Plomb 95 (E5)\n" +
            "- Sans Plomb 95 (E10)\n" +
            "- Superéthanol E85\n" +
            "- Gazole (B7)\n" +
            "- GPL ")
    public ResponseEntity<String> postGasStation(@RequestBody GasStation gasStation) {

        if(gasStation.gasStationName.equals("string")) {
            apiErrors.addError("404", "la station est vide");
            return ResponseEntity.badRequest().body("la valeur de l'id n'est pas correct");
        }
//        List<Fuel> fuelList = gasStation.fuels;
//        if() {
//            apiErrors.addError("404", "le carburant n'est pas correct");
//            return ResponseEntity.badRequest().body("la valeur de l'id du carburant n'est pas correct");
//        }
        gasStationRepository.save(gasStation);

       return ResponseEntity.ok(gasStation.id);
    }
}
