package com.xmart.reservationterrain.service;

import com.xmart.reservationterrain.entities.ReparationLumiere;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ReparationLumiereService {
    ReparationLumiere ajouterRparationLumiere(Long terrainId, LocalDateTime heure) throws Exception;
    ReparationLumiere reLuParTerrainEtParHeure(Long terrainId, LocalDateTime heure);
    List<ReparationLumiere> reLuParJour(LocalDate jour);
}
