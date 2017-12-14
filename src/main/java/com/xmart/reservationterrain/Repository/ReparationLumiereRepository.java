package com.xmart.reservationterrain.Repository;

import com.xmart.reservationterrain.entities.ReparationLumiere;
import com.xmart.reservationterrain.entities.Terrain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RepositoryRestResource
@CrossOrigin("*")
public interface ReparationLumiereRepository extends JpaRepository<ReparationLumiere,Long>{
    ReparationLumiere findByTerrainAndHeure(Terrain terrain, LocalDateTime heure);
    List<ReparationLumiere> findByHeureBetween(LocalDateTime debut, LocalDateTime fin);
}
