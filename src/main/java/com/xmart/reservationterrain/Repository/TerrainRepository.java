package com.xmart.reservationterrain.Repository;

import com.xmart.reservationterrain.entities.Terrain;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource
@CrossOrigin("*")
public interface TerrainRepository extends JpaRepository<Terrain,Long>{
    public List<Terrain> findByType(int type);
}
