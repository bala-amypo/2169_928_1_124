package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private String password;
    private String role;
    private boolean isActive;

    public UserAccount() {}

    // REQUIRED constructor
    public UserAccount(Long id, String username, String email,
                       String password, String role, boolean isActive) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.isActive = isActive;
    }

    // getters & setters...
}
