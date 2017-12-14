package com.xmart.reservationterrain.service;

import com.xmart.reservationterrain.entities.Seance;

import java.time.DayOfWeek;
import java.time.LocalTime;

public interface SeanceService {
    Seance ajouterSeance(DayOfWeek jour, LocalTime heure);
    Seance seanceParJourEtHeure(DayOfWeek jour, LocalTime heure);
}
