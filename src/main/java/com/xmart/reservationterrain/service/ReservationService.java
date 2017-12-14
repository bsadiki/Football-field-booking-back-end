package com.xmart.reservationterrain.service;

import com.xmart.reservationterrain.entities.Reservation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ReservationService {
     Reservation reserver(String clientId, Long terrainId, LocalDateTime date) throws Exception;
     Reservation annulerReservation(Long resrvationId) throws Exception;
     List<Reservation> reservationDansUnJour(LocalDate jour);
}
