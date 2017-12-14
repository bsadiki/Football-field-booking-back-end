package com.xmart.reservationterrain.Repository;

import com.xmart.reservationterrain.entities.Abonnement;
import com.xmart.reservationterrain.entities.Seance;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDate;
import java.util.List;

@RepositoryRestResource
@CrossOrigin("*")
public interface AbonnementRepository extends JpaRepository<Abonnement,Long>{
    List<Abonnement> findBySeanceAndStartBeforeAndEndAfter(Seance seance, LocalDate Jour,LocalDate jour);
    Page<Abonnement> findByStartBeforeAndEndAfter(LocalDate Jour, LocalDate jour, Pageable pageable);
}
