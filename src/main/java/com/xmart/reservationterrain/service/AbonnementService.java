package com.xmart.reservationterrain.service;

import com.xmart.reservationterrain.entities.Abonnement;
import com.xmart.reservationterrain.entities.Seance;
import org.springframework.data.domain.Page;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public interface AbonnementService {
    Abonnement ajouterAbonnement(String client_id, LocalDate start, int duree, DayOfWeek jour, LocalTime heure, int type) throws Exception;
    List<Abonnement> abonnementDansUneDate(LocalDateTime localDateTime);
    Page<Abonnement> abonnementsCourants(int page, int size);
}
