package com.example.birthdayapp.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String email;

    @OneToMany(mappedBy="users")
    private Set<Birthday> birthdays;

    public Users() {
        super();
    }

    public Users(Long id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public Set<Birthday> getBirthdays() {
        return birthdays;
    }

    @Override
    public String toString() {
        return "Users{" +
                "mId=" + id +
                ", mUsername='" + username + '\'' +
                ", mPassword='" + password + '\'' +
                ", mEmail='" + email + '\'' +
                '}';
    }
}
