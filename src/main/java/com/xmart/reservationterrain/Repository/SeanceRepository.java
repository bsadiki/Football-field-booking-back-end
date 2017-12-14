package com.xmart.reservationterrain.Repository;

import com.xmart.reservationterrain.entities.Seance;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.DayOfWeek;
import java.time.LocalTime;

@RepositoryRestResource
@CrossOrigin("*")
public interface SeanceRepository extends JpaRepository<Seance,Long>{
    Seance findByJourAndHeure(DayOfWeek jour, LocalTime heure);
}
