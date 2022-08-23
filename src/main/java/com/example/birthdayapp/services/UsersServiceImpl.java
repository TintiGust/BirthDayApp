package com.example.birthdayapp.services;

import com.example.birthdayapp.models.Birthday;
import com.example.birthdayapp.models.Users;
import com.example.birthdayapp.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository mUsersRepository;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.mUsersRepository = usersRepository;
    }

    @Override
    public Optional<Users> login(String pUsername, String pPassword) {
        return mUsersRepository.findUsersByUsernameAndPassword(pUsername, pPassword);
    }

    @Override
    public List<Users> getAllUsers() {
        return mUsersRepository.findAll();
    }

    @Override
    public Users save(Users pUsers) {
        return mUsersRepository.save(pUsers);
    }

    @Override
    public Optional<Users> getUsersById(Long id) {
        return mUsersRepository.findById(id);
    }


}

