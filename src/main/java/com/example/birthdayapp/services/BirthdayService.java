package com.example.birthdayapp.services;

import com.example.birthdayapp.models.Birthday;

import java.util.List;

public interface BirthdayService {

    public List<Birthday> getAllBirthdays();
    public List<Birthday> getBirthdaysByUsersId(Long userId);
    public Birthday save(Birthday birthday);
}
