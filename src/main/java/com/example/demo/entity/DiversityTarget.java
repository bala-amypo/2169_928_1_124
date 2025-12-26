package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class DiversityTarget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int targetYear;
    private double targetPercentage;

    @ManyToOne
    private DiversityClassification classification;

    public DiversityTarget() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public int getTargetYear() { return targetYear; }
    public void setTargetYear(int targetYear) { this.targetYear = targetYear; }

    public double getTargetPercentage() { return targetPercentage; }
    public void setTargetPercentage(double targetPercentage) {
        this.targetPercentage = targetPercentage;
    }

    public DiversityClassification getClassification() { return classification; }
    public void setClassification(DiversityClassification classification) {
        this.classification = classification;
    }
}
