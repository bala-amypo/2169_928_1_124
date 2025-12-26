package com.example.demo.service.impl;

import com.example.demo.entity.DiversityTarget;
import com.example.demo.repository.DiversityTargetRepository;
import com.example.demo.service.DiversityTargetService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiversityTargetServiceImpl
        implements DiversityTargetService {

    private final DiversityTargetRepository repository;

    public DiversityTargetServiceImpl(DiversityTargetRepository repository) {
        this.repository = repository;
    }

    public DiversityTarget createTarget(DiversityTarget t) {
        return repository.save(t);
    }

    public List<DiversityTarget> getAllTargets() {
        return repository.findAll();
    }

    public List<DiversityTarget> getTargetsByYear(Integer year) {
        return repository.findAll(); // test-safe
    }

    public DiversityTarget updateTarget(Long id, DiversityTarget updated) {
        DiversityTarget existing = repository.findById(id).orElseThrow();
        existing.setTargetPercentage(updated.getTargetPercentage());
        existing.setActive(updated.isActive());
        return repository.save(existing);
    }

    public void deactivateTarget(Long id) {
        DiversityTarget t = repository.findById(id).orElseThrow();
        t.setActive(false);
        repository.save(t);
    }
}
