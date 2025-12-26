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

    @Override
    public DiversityTarget create(DiversityTarget target) {
        return repository.save(target);
    }

    @Override
    public List<DiversityTarget> getAll() {
        return repository.findAll();
    }

    @Override
    public DiversityTarget update(Long id, DiversityTarget updated) {
        DiversityTarget existing =
                repository.findById(id).orElseThrow();

        existing.setTargetPercentage(updated.getTargetPercentage());

        return repository.save(existing);
    }

    @Override
    public void deactivateTarget(Long id) {
        DiversityTarget target =
                repository.findById(id).orElseThrow();

        target.setActive(false);
        repository.save(target);
    }
}
