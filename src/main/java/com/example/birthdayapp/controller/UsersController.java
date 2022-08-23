package com.example.birthdayapp.controller;

import com.example.birthdayapp.models.Users;
import com.example.birthdayapp.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping(value = {"", "/"})
    public List<Users> getUsers(){
        return usersService.getAllUsers();
    }

    @GetMapping("/{usersId}")
    public Optional<Users> getUsersById(@PathVariable("usersId") Long id){
        return usersService.getUsersById(id);
    }
}
