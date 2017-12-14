package com.xmart.reservationterrain.Repository;

import com.xmart.reservationterrain.entities.security.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority,Long> {
}
