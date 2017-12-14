package com.xmart.reservationterrain.controller;

import com.xmart.reservationterrain.entities.Abonnement;
import com.xmart.reservationterrain.service.AbonnementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@RestController
@Api(tags = "AbonnementController")
@CrossOrigin("*")

public class AbonnementController {
    @Autowired
    AbonnementService abonnementService;
    @PostMapping(value = "/ajouterAbonnement/{client_id}/{start}/{duree}/{jour}/{heure}/{type}/")
    @ApiOperation(value = "ajouter un nouveau abonnement")
    Abonnement ajouterAbonnement(@PathVariable String client_id,
                                 @PathVariable
                                 @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate start,
                                 @PathVariable int duree,
                                 @PathVariable DayOfWeek jour,
                                 @PathVariable
                                 @DateTimeFormat(pattern="HH:mm") LocalTime heure,
                                 @PathVariable int type) throws Exception {
        return abonnementService.ajouterAbonnement(client_id,start,duree,jour,heure,type);
    }
    @GetMapping(value = "/abonnementDansUneDate/{dateEtHeure}/")
    @ApiOperation(value = "abonnement pendant une date et une heure")
    List<Abonnement> abonnementDansUneDate(@PathVariable
                                           @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") LocalDateTime dateEtHeure){
        return abonnementService.abonnementDansUneDate(dateEtHeure);
    }
    @GetMapping(value = "/abonnementsCourants/")
    @ApiOperation(value = "abonnements Courants")
    Page<Abonnement> abonnementsCourants(@RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "5") int size){
        return abonnementService.abonnementsCourants(page, size);
    }
}
