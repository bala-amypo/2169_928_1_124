package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.List;

@Entity
public class Supplier {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String name;

    @Column(unique = true)
    private String email;

    private String registrationNumber;
    private String phone;
    private String address;

    private Boolean isActive = true;

    private Instant createdAt;
    private Instant updatedAt;

    @ManyToMany
    private List<DiversityClassification> diversityClassifications;

    @PrePersist
    void onCreate() {
        createdAt = Instant.now();
    }

    // getters and setters
}
