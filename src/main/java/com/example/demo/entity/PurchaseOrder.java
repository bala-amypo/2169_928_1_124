package com.example.demo.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class PurchaseOrder {

    @Id
    @GeneratedValue
    private Long id;

    private String poNumber;

    @ManyToOne
    private Supplier supplier;

    @ManyToOne
    private SpendCategory category;

    private BigDecimal amount;
    private LocalDate dateIssued;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public LocalDate getDateIssued() { return dateIssued; }
    public void setDateIssued(LocalDate dateIssued) { this.dateIssued = dateIssued; }
}
