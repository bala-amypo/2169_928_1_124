package com.example.demo.service.impl;

import com.example.demo.entity.DiversityClassification;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.DiversityClassificationRepository;
import com.example.demo.service.DiversityClassificationService;

import java.util.List;

public class DiversityClassificationServiceImpl
        implements DiversityClassificationService {

    private final DiversityClassificationRepository repository;

    public DiversityClassificationServiceImpl(
            DiversityClassificationRepository repository) {
        this.repository = repository;
    }

    @Override
    public DiversityClassification createClassification(DiversityClassification c) {
        return repository.save(c);
    }

    @Override
    public DiversityClassification updateClassification(Long id, DiversityClassification c) {
        DiversityClassification existing = getById(id);
        c.setId(existing.getId());
        return repository.save(c);
    }

    @Override
    public DiversityClassification getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Classification not found"));
    }

    @Override
    public List<DiversityClassification> getAllClassifications() {
        return repository.findByActiveTrue();
    }

    @Override
    public void deactivateClassification(Long id) {
        DiversityClassification c = getById(id);
        c.setActive(false);
        repository.save(c);
    }
}
