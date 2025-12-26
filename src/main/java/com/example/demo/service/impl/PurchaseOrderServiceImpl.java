package com.example.demo.service.impl;

import com.example.demo.entity.PurchaseOrder;
import com.example.demo.repository.PurchaseOrderRepository;
import com.example.demo.service.PurchaseOrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    private final PurchaseOrderRepository repository;

    public PurchaseOrderServiceImpl(PurchaseOrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public PurchaseOrder create(PurchaseOrder po) {
        return repository.save(po);
    }

    @Override
    public List<PurchaseOrder> getAll() {
        return repository.findAll();
    }

    @Override
    public PurchaseOrder update(Long id, PurchaseOrder updated) {
        PurchaseOrder existing =
                repository.findById(id).orElseThrow();

        existing.setAmount(updated.getAmount());
        existing.setDateIssued(updated.getDateIssued());
        existing.setSupplier(updated.getSupplier());

        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
