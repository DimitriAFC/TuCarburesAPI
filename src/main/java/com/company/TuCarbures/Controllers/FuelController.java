package com.company.TuCarbures.Controllers;

import com.company.TuCarbures.Classes.Fuel;
import com.company.TuCarbures.Repositories.FuelRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class FuelController {

    @Autowired
    ServiceFuel serviceFuel;

    @GetMapping(path = "fuel/{id}")
    @Operation(summary = "Obtenir le code européen et le nom d'un carburant en fonction de son ID")
    public String GetFuelId(@PathVariable("id") String id) {
        Optional<Fuel> byId = serviceFuel.findFuel(id);
        String fuelName = byId.get().getFuelName();
        String europeanCode = byId.get().europeanCode;
        return "Carburant : " + fuelName + " , code europeen : " + europeanCode;
    }

    @GetMapping(path = "/Fuel")
    @Operation(summary = " Obtenir TOUT les carburants : nom, code européen ")
    public HashMap<String, String> GetAllFuel() {
        List<Fuel> listFuel = new ArrayList<Fuel>();
        Iterable<Fuel> all = fuelRepository.findAll();
        all.iterator().forEachRemaining(listFuel::add);
        HashMap<String, String> nameFuelAndCodeEuropean = new HashMap<>();
        for (Fuel fuel : listFuel) {
            String name = fuel.fuelName;
            String code = fuel.europeanCode;
            nameFuelAndCodeEuropean.put(name, code);
        }
        return nameFuelAndCodeEuropean;
    }

    @PostMapping(value = "Fuel/add")
    @Operation(summary = "Ajouter un carburant")
    public ResponseEntity<String> postFuel(@RequestBody Fuel fuel) {
        serviceFuel.saveFuel(fuel);
        return ResponseEntity.ok(fuel.id);
    }

}

