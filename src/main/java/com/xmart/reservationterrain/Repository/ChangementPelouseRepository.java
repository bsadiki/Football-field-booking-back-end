package com.xmart.reservationterrain.Repository;

import com.xmart.reservationterrain.entities.ChangementPelouse;
import com.xmart.reservationterrain.entities.Terrain;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RepositoryRestResource
@CrossOrigin("*")
public interface ChangementPelouseRepository extends JpaRepository<ChangementPelouse,Long>{
    ChangementPelouse findByTerrainAndJournee(Terrain terrain, LocalDate journee);
    List<ChangementPelouse> findByJournee(LocalDate journee);
}
