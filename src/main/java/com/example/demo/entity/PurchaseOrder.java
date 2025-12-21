package com.example.demo.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class PurchaseOrder {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String poNumber;

    @ManyToOne
    private Supplier supplier;

    @ManyToOne
    private SpendCategory category;

    private BigDecimal amount;
    private LocalDate dateIssued;
    private String approvedBy;
    private String notes;

    // getters and setters
}
