package com.xmart.reservationterrain.service;

import com.xmart.reservationterrain.entities.security.User;
import org.springframework.data.domain.Page;

public interface UserService {
    User addUser(String username, String password, String authoritie);
    Page<User> getUsers(int page, int size);
}
