package com.xmart.reservationterrain.service;

import com.xmart.reservationterrain.entities.ChangementPelouse;

import java.time.LocalDate;
import java.util.List;

public interface ChangementPelouseService {
    ChangementPelouse ajouterChangementPelouse(Long terrainId, LocalDate jour) throws Exception;

    List<ChangementPelouse> chPlJour(LocalDate jour);
}
