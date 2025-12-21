package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
public class UserAccount {

    @Id
    @GeneratedValue
    private Long id;

    private String fullName;

    @Column(unique = true)
    private String email;

    private String password;
    private String role = "USER";

    private Instant createdAt;

    @PrePersist
    void onCreate() {
        createdAt = Instant.now();
    }

    // getters and setters
}
