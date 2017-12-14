package com.xmart.reservationterrain.controller;

import com.xmart.reservationterrain.Repository.ReparationLumiereRepository;
import com.xmart.reservationterrain.Repository.TerrainRepository;
import com.xmart.reservationterrain.entities.ReparationLumiere;
import com.xmart.reservationterrain.entities.Terrain;
import com.xmart.reservationterrain.service.ReparationLumiereService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@Api(tags = "ReparationLumiereController")
@CrossOrigin("*")
public class ReparationLumiereController {
    @Autowired
    ReparationLumiereService reparationLumiereService;

    @PostMapping(value = "/ajouterReparationLumiere/{terrainId}/{heure}")
    @ApiOperation(value = "planifier une reparation de lumiere")
    ReparationLumiere ajouterReparationLumiere(@PathVariable Long terrainId,
                                              @PathVariable
                                              @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") LocalDateTime heure) throws Exception {
        return reparationLumiereService.ajouterRparationLumiere(terrainId, heure);
    }

    @GetMapping(value = "/reLuParTerrainEtParHeure/{terrainId}/{heure}")
    @ApiOperation("Chercher les reparations de lumiere par terrain et par heure")
    ReparationLumiere reLuParTerrainEtParHeure(@PathVariable Long terrainId,
                                            @PathVariable
                                            @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") LocalDateTime heure) {
        return reparationLumiereService.reLuParTerrainEtParHeure(terrainId, heure);
    }
    @GetMapping(value = "/reLuParJour/{jour}")
    @ApiOperation("Chercher les reparations de lumiere par jour")
    List<ReparationLumiere> reLuParJour(@PathVariable
                                        @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate jour){
        return reparationLumiereService.reLuParJour(jour);
    }
}
