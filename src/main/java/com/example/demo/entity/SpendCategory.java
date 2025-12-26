package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "spend_category")
public class SpendCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private boolean active = true;

    public SpendCategory() {}

    public Long getId() {
        return id;
    }

    // ❌ NO setId()

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
