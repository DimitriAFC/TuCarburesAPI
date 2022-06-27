package com.company.TuCarbures.Controllers;
import io.swagger.v3.oas.annotations.Operation;
import com.company.TuCarbures.GasStation;
import com.company.TuCarbures.Repositories.GasStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GasStationController {

    @Autowired
    GasStationRepository gasStationRepository;


    @ConfigurationProperties
    @PostMapping(value = "/StationService")
    @Operation(summary = "ajouter une station")
    public ResponseEntity<String> postGasStation(@RequestBody GasStation gasStation) {
        gasStationRepository.save(gasStation);
       return ResponseEntity.ok(gasStation.id);
    }
}
