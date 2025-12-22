package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class SpendCategory {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String description;
    private Boolean active = true;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
}
