package com.example.birthdayapp.controller;

import com.example.birthdayapp.models.Users;
import com.example.birthdayapp.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UsersService usersService;

    @PostMapping({""})
    public ResponseEntity<Users> login(@RequestParam("username") String username,
                       @RequestParam("password") String password){

        if (usersService.login(username, password) != null){
            return ResponseEntity.ok(usersService.login(username, password));
        }
        else{
            return ResponseEntity.badRequest().build();
        }
    }
}
