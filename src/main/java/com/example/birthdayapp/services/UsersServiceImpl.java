package com.example.birthdayapp.services;

import com.example.birthdayapp.models.Birthday;
import com.example.birthdayapp.models.Users;
import com.example.birthdayapp.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository mUsersRepository;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.mUsersRepository = usersRepository;
    }

    @Override
    public Users login(String pUsername, String pPassword) {
        if (mUsersRepository.findUsersByUsernameAndPassword(pUsername, pPassword).isPresent()){
            return mUsersRepository.findUsersByUsernameAndPassword(pUsername, pPassword).get();
        }
        else{
            return null;
        }
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
    public Users getUsersById(Long id) {
        if (mUsersRepository.findById(id).isPresent()){
           return mUsersRepository.findById(id).get();
        }
        else{
            return null;
        }
    }


}

