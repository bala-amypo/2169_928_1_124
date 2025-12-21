package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.List;

@Entity
public class Supplier {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String email;
    private String registrationNumber;
    private String phone;
    private String address;

    private Boolean isActive = true;

    private Instant createdAt;

    @ManyToMany
    private List<DiversityClassification> diversityClassifications;

    @PrePersist
    void onCreate() {
        createdAt = Instant.now();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean isActive) { this.isActive = isActive; }
}
