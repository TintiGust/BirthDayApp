package com.example.birthdayapp.repositories;

import com.example.birthdayapp.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {

    Optional<Users> findUsersByUsernameAndPassword(String username, String password);

}
