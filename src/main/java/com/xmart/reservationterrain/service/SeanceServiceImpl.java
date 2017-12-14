package com.xmart.reservationterrain.service;

import com.xmart.reservationterrain.Repository.SeanceRepository;
import com.xmart.reservationterrain.entities.Seance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalTime;
@Service
public class SeanceServiceImpl implements SeanceService {
    @Autowired
    SeanceRepository seanceRepository;
    @Override
    public Seance ajouterSeance(DayOfWeek jour, LocalTime heure) {
        return seanceRepository.save(new Seance(jour,heure));
    }

    @Override
    public Seance seanceParJourEtHeure(DayOfWeek jour, LocalTime heure) {
        return seanceRepository.findByJourAndHeure(jour,heure);
    }
}
