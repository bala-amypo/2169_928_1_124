package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "supplier")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private boolean isActive = true;

    @ManyToMany
    private Set<DiversityClassification> diversityClassifications = new HashSet<>();

    public Supplier() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIsActive(boolean active) {
        this.isActive = active;
    }

    public Set<DiversityClassification> getDiversityClassifications() {
        return diversityClassifications;
    }
}
