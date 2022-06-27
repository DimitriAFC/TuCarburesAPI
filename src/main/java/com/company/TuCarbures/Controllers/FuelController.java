package com.company.TuCarbures.Controllers;

import com.company.TuCarbures.Repositories.FuelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FuelController {

    @Autowired
    FuelRepository fuelRepository;
}
