package com.darrenyou.librarymanagement;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String phone;
    private String password;
    private String name;

    private Timestamp registrationTime;
    private Timestamp lastLoginTime;

    public User() {
    }

    public User(String phone, String password) {
        this.phone = phone;
        this.password = password;
    }

    public User(int id, String phone, String password, String name, Timestamp registrationTime, Timestamp lastLoginTime) {
        this.id = id;
        this.phone = phone;
        this.password = password;
        this.name = name;
        this.registrationTime = registrationTime;
        this.lastLoginTime = lastLoginTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(Timestamp registrationTime) {
        this.registrationTime = registrationTime;
    }

    public Timestamp getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Timestamp lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
}
