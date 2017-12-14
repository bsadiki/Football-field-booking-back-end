package com.xmart.reservationterrain.service;

import com.xmart.reservationterrain.Repository.ChangementPelouseRepository;
import com.xmart.reservationterrain.Repository.TerrainRepository;
import com.xmart.reservationterrain.entities.ChangementPelouse;
import com.xmart.reservationterrain.entities.Terrain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service

public class ChangementPelouseServiceImpl implements ChangementPelouseService {
    @Autowired
    ChangementPelouseRepository changementPelouseRepository;
    @Autowired
    TerrainRepository terrainRepository;

    @Override
    public ChangementPelouse ajouterChangementPelouse(Long terrainId, LocalDate jour) throws Exception {
        if (jour.isBefore(LocalDate.now()))
            throw new Exception("Impossible de plannifier un changement de pelouse avant la date d'aujourd'hui");
        Terrain terrain = terrainRepository.findOne(terrainId);
        if (terrain == null)
            throw new Exception("Terrain introuvable");
        ChangementPelouse changementPelouse = new ChangementPelouse(terrain, jour);
        return changementPelouseRepository.save(changementPelouse);
    }

    @Override
    public List<ChangementPelouse> chPlJour(LocalDate jour) {
        return changementPelouseRepository.findByJournee(jour);
    }
}
