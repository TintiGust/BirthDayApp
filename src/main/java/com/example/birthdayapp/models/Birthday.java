package com.example.birthdayapp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Birthday {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private String firstname;
    private String lastname;

    @ManyToOne
    @JoinColumn(name = "fk_user_id", nullable = false)
    private Users users;

    public Birthday(){
        super();
    }

    public Birthday(Long id, LocalDate date, String firstname, String lastname, Users users){
        super();
        this.id = id;
        this.date = date;
        this.firstname = firstname;
        this.lastname = lastname;
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getFirstName() {
        return firstname;
    }

    public String getLastName() {
        return lastname;
    }

    @JsonIgnore
    public Users getUsers() {
        return users;
    }

    @Override
    public String toString() {
        return "Birthday{" +
                "mId=" + id +
                ", mDate=" + date +
                ", mFirstName='" + firstname + '\'' +
                ", mLastName='" + lastname + '\'' +
                ", mFkUserId='" + users + '\'' +
                '}';
    }
}
