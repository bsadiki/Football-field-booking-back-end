package com.xmart.reservationterrain.service;

import com.xmart.reservationterrain.Repository.AuthorityRepository;
import com.xmart.reservationterrain.Repository.UserRepository;
import com.xmart.reservationterrain.entities.security.Authority;
import com.xmart.reservationterrain.entities.security.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    AuthorityRepository authorityRepository;
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Override
    public User addUser(String username, String password, String authoritie) {
        User user=new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder().encode(password));
        user.setEnabled(true);
        List<Authority> authorities=new ArrayList<>();
        authorities.add(authorityRepository.findOne(Long.valueOf(1)));
        if(authoritie.equals("ADMIN")){
            authorities.add(authorityRepository.findOne(Long.valueOf(2)));
        }
        user.setAuthorities(authorities);
        return userRepository.save(user);
    }

    @Override
    public Page<User> getUsers(int page, int size) {
        return userRepository.findAll(new PageRequest(page,size));
    }
}
