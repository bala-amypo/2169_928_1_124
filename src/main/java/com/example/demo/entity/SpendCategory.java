package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class SpendCategory {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String name;

    private String description;
    private Boolean active = true;

    // getters and setters
}
