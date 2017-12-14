package com.xmart.reservationterrain.Repository;

import com.xmart.reservationterrain.entities.Reservation;
import com.xmart.reservationterrain.entities.Terrain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,Long>{
    Reservation findByTerrainAndDate(Terrain terrain, LocalDateTime date);
    List<Reservation> findByDateBetween(LocalDateTime debutDuJour, LocalDateTime finDuJour);
}
