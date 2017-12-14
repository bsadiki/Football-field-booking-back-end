package com.xmart.reservationterrain.controller;

import com.xmart.reservationterrain.entities.ChangementPelouse;
import com.xmart.reservationterrain.service.ChangementPelouseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@Api(tags = "ChangementPelouseController")
@CrossOrigin("*")
public class ChangementPelouseController {
    @Autowired
    ChangementPelouseService changementPelouseService;

    @PostMapping(value = "/ajouterChangementPelouse/{terrainId}/{jour}")
    @ApiOperation(value = "planifier un changement de pelouse")
    ChangementPelouse ajouterChangementPelouse(@PathVariable Long terrainId,
                                               @PathVariable
                                               @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate jour) throws Exception {

        return changementPelouseService.ajouterChangementPelouse(terrainId, jour);
    }

    @GetMapping(value = "/chPlParDate/{date}")
    @ApiOperation("chercher les changements de pelouse par jour")
    List<ChangementPelouse> chPlParJour(@PathVariable
                                        @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return changementPelouseService.chPlJour(date);
    }
}
