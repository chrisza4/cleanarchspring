package com.chrisza.cleandemo.persistence.entities;

import javax.persistence.*;

@Entity
@Table(name = "\"user\"")
public class User {

    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private String username;
    private String hashPassword;

    public User() {
    }

    public User(String username, String hashPassword) {
        this.username = username;
        this.hashPassword = hashPassword;
    }

    public static User NewFromEntity(com.chrisza.cleandemo.entities.User entity) {
        return new User(entity.username, entity.GetHashedPassword());
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHashPassword() {
        return hashPassword;
    }

    public void setHashPassword(String hashPassword) {
        this.hashPassword = hashPassword;
    }
}