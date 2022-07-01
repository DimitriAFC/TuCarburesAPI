package com.company.TuCarbures.Controllers;

import com.company.TuCarbures.ApiErrors;
import com.company.TuCarbures.Classes.FuelAvailableDto;
import com.company.TuCarbures.Classes.GasStation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/StationService")
@Slf4j
@Tag(name = "API", description = "gestion des stations services")
public class ApiController {

    @Autowired
    ServiceGasStation serviceGasStation;

    @Autowired
    ServiceDelta serviceDelta;

    private ApiErrors apiErrors = new ApiErrors();

    @GetMapping(value = "/Releve/{id}")
    @Operation(
            tags = "Relevé GasStation",
            summary = "relevé de prix de chaque carburant disponible pour une station avec la date",
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
    public List<FuelAvailableDto> priceOfFuels(@PathVariable("id") String id) {
        Optional<GasStation> station = serviceGasStation.findGastation(id);
        return FuelAvailableDto.convertOptionalToList(station);
    }

    //Fournir la station la plus proche proposant le carburant le moins cher, avec le prix du
    //carburant et la date du dernier relevé pour ce carburant (en fonction de la distance
    //max, et du carburant)

    @GetMapping(value = "/GasStationLessExpensive")
    @Operation(
            tags = "Relevé GasStation Less Expensive",
            summary = "station la plus proche proposant le carburant le moins cher",
            parameters = {
                    @Parameter(
                            name = "distance",
                            description = "la distance maximum",
                            required = true
                    ),
                    @Parameter(
                            name = "nom",
                            description = "nom carburant : " +
                                    "- Sans Plomb 98 \n" +
                                    "- Sans Plomb 95 \n" +
                                    "- Superéthanol\n" +
                                    "- Gazole \n" +
                                    "- GPL",
                            required = true
                    ),
                    @Parameter(
                            name = "code",
                            description= "Code Européen : E5 ,E10 ,E85 ,B7 LPG",
                            required = true
                    )
            },
            responses = {
                    @ApiResponse(responseCode = "200",
                            description = "Successfuly ",
                            content = @Content(schema = @Schema(implementation = GasStation.class))
                    ),
                    @ApiResponse(responseCode = "400",
                            description = " Not found"),
                    @ApiResponse(responseCode = "500",
                            description = "Error servor "
                    ),
            })
    public List<GasStation> gasStationDistanceAndFuelLessExpensive(long distance, String nom, String code) {

        List<GasStation> result = new ArrayList<>();
        Iterable<GasStation> stations = serviceGasStation.findAllStation();
        stations.forEach(result::add);
        List<Optional> listeStation = serviceGasStation.filterFuel(result,nom,code);

        return null;
    }

}
