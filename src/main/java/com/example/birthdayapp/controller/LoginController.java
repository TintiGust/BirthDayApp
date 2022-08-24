package com.example.birthdayapp.controller;

import com.example.birthdayapp.models.Users;
import com.example.birthdayapp.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UsersService usersService;

    @GetMapping({"/{username}/{password}"})
    public Users login(@PathVariable("username") String username, @PathVariable("password") String password){
        return usersService.login(username, password);
    }
}
