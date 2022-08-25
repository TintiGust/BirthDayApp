package com.example.birthdayapp.controller;

import com.example.birthdayapp.models.Birthday;
import com.example.birthdayapp.models.Users;
import com.example.birthdayapp.services.BirthdayService;
import com.example.birthdayapp.services.UsersService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private BirthdayService birthdayService;

    @GetMapping(value = {"", "/"})
    public List<Users> getUsers(){
        return usersService.getAllUsers();
    }

    @PostMapping("/{usersId}")
    public ResponseEntity<Users> getUsersById(@PathVariable("usersId") Long id){
        try{
            return ResponseEntity.ok(usersService.getUsersById(id));
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("")
    public Users saveUsers(@RequestParam("username") String username,
                           @RequestParam("password") String password,
                           @RequestParam("email") String email){
        Users users = new Users(null, username, password, email);
        return usersService.save(users);
    }

    @PostMapping("/{userId}/birthdays")
    public Birthday saveBirthday(@PathVariable("userId") Long userId,
                                 @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
                                 @RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName){
        Birthday birthday = new Birthday(null, date, firstName, lastName, (usersService.getUsersById(userId)));
        return birthdayService.save(birthday);
    }

    @PutMapping("/{userId}/birthdays")
    public Birthday updateBirthday(@RequestParam("birthdayId") Long birthdayId,
                                   @RequestParam("firstName") String firstName,
                                   @RequestParam("lastName") String lastName,
                                   @RequestParam("date") LocalDate date){
        Birthday birthday = birthdayService.getBirthdayById(birthdayId);
        birthday.setDate(date);
        birthday.setFirstname(firstName);
        birthday.setLastname(lastName);
        return birthday;
    }
}
