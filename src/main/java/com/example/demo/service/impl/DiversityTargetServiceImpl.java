package com.example.demo.service.impl;

import com.example.demo.entity.DiversityTarget;
import com.example.demo.repository.DiversityTargetRepository;
import com.example.demo.service.DiversityTargetService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiversityTargetServiceImpl implements DiversityTargetService {

    private final DiversityTargetRepository repository;

    public DiversityTargetServiceImpl(DiversityTargetRepository repository) {
        this.repository = repository;
    }

    @Override
    public DiversityTarget createTarget(DiversityTarget target) {
        return repository.save(target);
    }

    @Override
    public DiversityTarget getById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public List<DiversityTarget> getAllTargets() {
        return repository.findAll();
    }

    @Override
    public DiversityTarget updateTarget(Long id, DiversityTarget target) {
        DiversityTarget existing = getById(id);
        existing.setTargetPercentage(target.getTargetPercentage());
        existing.setActive(target.isActive());
        return repository.save(existing);
    }

    @Override
    public void deactivateTarget(Long id) {
        DiversityTarget target = getById(id);
        target.setActive(false);
        repository.save(target);
    }
}
