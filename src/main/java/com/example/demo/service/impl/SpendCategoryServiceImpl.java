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

    @Override
    public SpendCategory createCategory(SpendCategory category) {
        return repository.save(category);
    }

    @Override
    public List<SpendCategory> getAllCategories() {
        return repository.findAll();
    }

    @Override
    public SpendCategory updateCategory(Long id, SpendCategory updated) {
        SpendCategory existing =
                repository.findById(id).orElseThrow();

        existing.setName(updated.getName());
        existing.setIsActive(updated.isIsActive());

        return repository.save(existing);
    }

    @Override
    public void deactivateCategory(Long id) {
        SpendCategory category =
                repository.findById(id).orElseThrow();

        category.setIsActive(false);
        repository.save(category);
    }
}
