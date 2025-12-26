package com.example.demo.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "purchase_order")
public class PurchaseOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;
    private LocalDate dateIssued;

    @ManyToOne
    private Supplier supplier;

    public PurchaseOrder() {}

    public Long getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDate getDateIssued() {
        return dateIssued;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setDateIssued(LocalDate dateIssued) {
        this.dateIssued = dateIssued;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
