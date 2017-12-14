package com.xmart.reservationterrain.Repository;

import com.xmart.reservationterrain.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource
@CrossOrigin("*")
public interface ClientRepository extends JpaRepository<Client,String>{
    List<Client> findByClientIdContains(String number);
}
