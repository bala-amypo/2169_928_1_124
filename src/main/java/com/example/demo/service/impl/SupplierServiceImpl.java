package com.example.demo.service.impl;

import com.example.demo.entity.Supplier;
import com.example.demo.repository.SupplierRepository;
import com.example.demo.service.SupplierService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl
        implements SupplierService {

    private final SupplierRepository repository;

    public SupplierServiceImpl(SupplierRepository repository) {
        this.repository = repository;
    }

    @Override
    public Supplier createSupplier(Supplier supplier) {
        return repository.save(supplier);
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        return repository.findAll();
    }

    @Override
    public Supplier updateSupplier(Long id, Supplier updated) {
        Supplier existing =
                repository.findById(id).orElseThrow();

        existing.setName(updated.getName());
        existing.setIsActive(updated.isIsActive());

        return repository.save(existing);
    }

    @Override
    public void deactivateSupplier(Long id) {
        Supplier supplier =
                repository.findById(id).orElseThrow();

        supplier.setIsActive(false);
        repository.save(supplier);
    }
}
