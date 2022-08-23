package com.example.birthdayapp.repositories;

import com.example.birthdayapp.models.Birthday;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BirthdayRepository extends JpaRepository<Birthday, Long>  {


}
