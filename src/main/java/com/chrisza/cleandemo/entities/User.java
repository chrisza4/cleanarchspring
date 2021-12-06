package com.chrisza.cleandemo.entities;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class User {
    public String username;
    private String hashPassword;

    public User(String username) {
        this.username = username;
    }

    public void SetPassword(String password) {
        var encoder = new BCryptPasswordEncoder();
        hashPassword = encoder.encode(password);
    }

    public Boolean ValidatePassword(String password) {
        var encoder = new BCryptPasswordEncoder();
        return encoder.matches(password, hashPassword);
    }

    public String GetHashedPassword() {
        return this.hashPassword;
    }
}
