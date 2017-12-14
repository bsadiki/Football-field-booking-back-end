package com.xmart.reservationterrain.controller;

import com.xmart.reservationterrain.entities.Reservation;
import com.xmart.reservationterrain.service.ReservationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@Api(tags = "ReservationController")
@CrossOrigin("*")
public class ReservationController {
    @Autowired
    ReservationService reservationService;
    @PostMapping("/reserver/{clientId}/{terrainId}/{heure}")
    @ApiOperation(value = "reserver")
    Reservation reserver(@PathVariable String clientId,
                         @PathVariable Long terrainId,
                         @PathVariable
                         @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm") LocalDateTime heure) throws Exception {
            Reservation reservation= reservationService.reserver(clientId,terrainId,heure);
            return reservation;
    }
    @PostMapping("/annulerReservation/{resrvationId}/")
    @ApiOperation(value = "annuler une reservation")
    Reservation annulerReservation(@PathVariable Long resrvationId) throws Exception {
        return reservationService.annulerReservation(resrvationId);
    }
    @GetMapping("/reservationDansUnJour/{jour}/")
    @ApiOperation(value = "chercher les reservations par jour")
    List<Reservation> reservationsDansUnJour(@PathVariable
                                      @DateTimeFormat(pattern="yyyy-MM-dd")LocalDate jour) throws Exception {
        return reservationService.reservationDansUnJour(jour);
    }
}
