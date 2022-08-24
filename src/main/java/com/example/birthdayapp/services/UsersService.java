package com.example.birthdayapp.services;

import com.example.birthdayapp.models.Users;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UsersService {

    Users login(String username, String password);
    List<Users> getAllUsers();
    Users save(Users users);
    Users getUsersById(Long id);
}
