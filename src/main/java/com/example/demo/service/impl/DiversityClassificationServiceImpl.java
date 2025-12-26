package com.example.demo.service.impl;

import com.example.demo.entity.DiversityClassification;
import com.example.demo.repository.DiversityClassificationRepository;
import com.example.demo.service.DiversityClassificationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiversityClassificationServiceImpl
        implements DiversityClassificationService {

    private final DiversityClassificationRepository repository;

    public DiversityClassificationServiceImpl(DiversityClassificationRepository repository) {
        this.repository = repository;
    }

    public DiversityClassification createClassification(DiversityClassification c) {
        return repository.save(c);
    }

    public List<DiversityClassification> getAllClassifications() {
        return repository.findAll();
    }

    public DiversityClassification getById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public DiversityClassification updateClassification(Long id, DiversityClassification updated) {
        DiversityClassification existing = getById(id);
        existing.setName(updated.getName());
        existing.setActive(updated.isActive());
        return repository.save(existing);
    }

    public void deactivateClassification(Long id) {
        DiversityClassification c = getById(id);
        c.setActive(false);
        repository.save(c);
    }
}
