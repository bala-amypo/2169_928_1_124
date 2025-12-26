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

    public DiversityClassificationServiceImpl(
            DiversityClassificationRepository repository) {
        this.repository = repository;
    }

    @Override
    public DiversityClassification createClassification(DiversityClassification c) {
        return repository.save(c);
    }

    @Override
    public List<DiversityClassification> getAllClassifications() {
        return repository.findAll();
    }

    @Override
    public DiversityClassification updateClassification(Long id, DiversityClassification updated) {
        DiversityClassification existing =
                repository.findById(id).orElseThrow();

        existing.setName(updated.getName());
        existing.setIsActive(updated.isIsActive());

        return repository.save(existing);
    }

    @Override
    public void deactivateClassification(Long id) {
        DiversityClassification c =
                repository.findById(id).orElseThrow();

        c.setIsActive(false);
        repository.save(c);
    }
}
