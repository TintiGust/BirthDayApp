package com.example.birthdayapp.services;

import com.example.birthdayapp.models.Birthday;
import com.example.birthdayapp.models.Users;
import com.example.birthdayapp.repositories.BirthdayRepository;
import com.example.birthdayapp.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BirthdayServiceImpl implements BirthdayService {

    @Autowired
    private BirthdayRepository mBirthdayRepository;

    @Autowired
    private UsersRepository mUsersRepository;

    @Override
    public List<Birthday> getAllBirthdays() {
        return mBirthdayRepository.findAll();
    }

    //TODO : check exception in else
    @Override
    public List<Birthday> getBirthdaysByUsersId(Long userId) {
        Optional<Users> users = mUsersRepository.findById(userId);
        //return users.map(value -> (List<Birthday>) value.getBirthdays()).orElse(null);
        if (users.isPresent()){
            return (List<Birthday>) users.get().getBirthdays();
        }
        else{
            return null;
        }
    }

    @Override
    public Birthday save(Birthday birthday) {
        return mBirthdayRepository.save(birthday);
    }
}
