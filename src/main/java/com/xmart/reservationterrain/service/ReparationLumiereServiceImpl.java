package com.xmart.reservationterrain.service;

import com.xmart.reservationterrain.Repository.ReparationLumiereRepository;
import com.xmart.reservationterrain.Repository.TerrainRepository;
import com.xmart.reservationterrain.entities.ReparationLumiere;
import com.xmart.reservationterrain.entities.Terrain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class ReparationLumiereServiceImpl implements ReparationLumiereService {
    @Autowired
    TerrainRepository terrainRepository;
    @Autowired
    ReparationLumiereRepository reparationLumiereRepository;
    @Override
    public ReparationLumiere ajouterRparationLumiere(Long terrainId, LocalDateTime heure) throws Exception {
        Terrain terrain=terrainRepository.findOne(terrainId);
        heure=heure.minusMinutes(heure.getMinute());
        if(heure.isBefore(LocalDateTime.now()))
            throw new Exception("Impossible de planifier un changement de pelouse avant l'heure actuelle");
        ReparationLumiere reparationLumiere=new ReparationLumiere(terrain,heure);
        return reparationLumiereRepository.save(reparationLumiere);
    }

    @Override
    public ReparationLumiere reLuParTerrainEtParHeure(Long terrainId, LocalDateTime heure) {
        Terrain terrain=terrainRepository.findOne(terrainId);
        return reparationLumiereRepository.findByTerrainAndHeure(terrain,heure);
    }

    @Override
    public List<ReparationLumiere> reLuParJour(LocalDate jour) {
        LocalDateTime debut=jour.atStartOfDay();
        LocalDateTime fin=jour.plusDays(1).atStartOfDay();
        return reparationLumiereRepository.findByHeureBetween(debut,fin);
    }
}
