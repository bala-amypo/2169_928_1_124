package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class DiversityTarget {

    @Id
    @GeneratedValue
    private Long id;

    private Integer targetYear;
    private Double targetPercentage;
    private Boolean active = true;

    @ManyToOne
    private DiversityClassification classification;

    // getters and setters
}
