package com.xmart.reservationterrain.controller;

import com.xmart.reservationterrain.Repository.UserRepository;
import com.xmart.reservationterrain.entities.security.User;
import com.xmart.reservationterrain.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "UserController")
@CrossOrigin("*")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;
    @RequestMapping(method = RequestMethod.GET, value = "/getUsers")
    @ApiOperation(value = "get all users")
    @PreAuthorize("hasRole('ADMIN')")
    public Page<User> getUsers(@RequestParam(defaultValue = "0") int page,
                        @RequestParam(defaultValue = "5") int size){
        return userService.getUsers(page,size);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/addNewUser/{userName}/{password}/{authority}")
    @ApiOperation(value = "add new user")
    @PreAuthorize("hasRole('ADMIN')")
    public User addNewUser(@PathVariable String userName,
                    @PathVariable String password,
                    @PathVariable String authority){
        return userService.addUser(userName,password,authority);
    }

    @GetMapping(value = "/byUserName")
    @ApiOperation(value = "get by userName")
    @PreAuthorize("hasRole('ADMIN')")
    public User byUserName(@RequestParam String username){
        return userRepository.findByUsername(username);
    }
}
