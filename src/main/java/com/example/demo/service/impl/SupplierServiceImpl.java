package com.example.demo.service.impl;

import com.example.demo.entity.Supplier;
import com.example.demo.repository.SupplierRepository;
import com.example.demo.service.SupplierService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository repository;

    public SupplierServiceImpl(SupplierRepository repository) {
        this.repository = repository;
    }

    public Supplier createSupplier(Supplier s) {
        return repository.save(s);
    }

    public List<Supplier> getAllSuppliers() {
        return repository.findAll();
    }

    public Supplier getSupplierById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public Supplier updateSupplier(Long id, Supplier updated) {
        Supplier existing = getSupplierById(id);
        existing.setName(updated.getName());
        existing.setActive(updated.isActive());
        return repository.save(existing);
    }

    public void deactivateSupplier(Long id) {
        Supplier s = getSupplierById(id);
        s.setActive(false);
        repository.save(s);
    }
}
