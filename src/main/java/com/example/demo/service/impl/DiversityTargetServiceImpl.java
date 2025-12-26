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
        target.setActive(true);
        return repository.save(target);
    }

    @Override
    public DiversityTarget getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<DiversityTarget> getAllTargets() {
        return repository.findAll();
    }

    @Override
    public List<DiversityTarget> getTargetsByYear(Integer year) {
        return repository.findByYear(year);
    }

    // ✅ THIS METHOD WAS MISSING (CAUSE OF CURRENT ERROR)
    @Override
    public DiversityTarget updateTarget(Long id, DiversityTarget updated) {
        DiversityTarget existing = repository.findById(id).orElse(null);
        if (existing == null) {
            return null;
        }

        existing.setTargetPercentage(updated.getTargetPercentage());
        existing.setYear(updated.getYear());
        existing.setActive(updated.isActive());

        return repository.save(existing);
    }

    @Override
    public void deactivateTarget(Long id) {
        DiversityTarget target = repository.findById(id).orElse(null);
        if (target != null) {
            target.setActive(false);
            repository.save(target);
        }
    }
}
