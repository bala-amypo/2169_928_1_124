package com.example.demo.service.impl;

import com.example.demo.entity.SpendCategory;
import com.example.demo.repository.SpendCategoryRepository;
import com.example.demo.service.SpendCategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpendCategoryServiceImpl
        implements SpendCategoryService {

    private final SpendCategoryRepository repository;

    public SpendCategoryServiceImpl(SpendCategoryRepository repository) {
        this.repository = repository;
    }

    public SpendCategory createCategory(SpendCategory c) {
        return repository.save(c);
    }

    public List<SpendCategory> getAllCategories() {
        return repository.findAll();
    }

    public SpendCategory getCategoryById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public SpendCategory updateCategory(Long id, SpendCategory updated) {
        SpendCategory existing = getCategoryById(id);
        existing.setName(updated.getName());
        existing.setActive(updated.isActive());
        return repository.save(existing);
    }

    public void deactivateCategory(Long id) {
        SpendCategory c = getCategoryById(id);
        c.setActive(false);
        repository.save(c);
    }
}
