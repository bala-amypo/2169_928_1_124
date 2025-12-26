package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "diversity_target")
public class DiversityTarget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int targetPercentage;
    private boolean active = true;

    public DiversityTarget() {}

    public Long getId() {
        return id;
    }

    public int getTargetPercentage() {
        return targetPercentage;
    }

    public boolean isActive() {
        return active;
    }

    public void setTargetPercentage(int targetPercentage) {
        this.targetPercentage = targetPercentage;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
