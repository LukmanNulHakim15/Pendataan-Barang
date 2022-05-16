package com.example.Versi11.With.Validation.service;

import com.example.Versi11.With.Validation.model.entity.CategoryEntity;

import java.util.List;

public interface CategoryService {

    List<CategoryEntity> findAll();

    CategoryEntity save(CategoryEntity categoryEntity);

    CategoryEntity findById(Long id);

    List<CategoryEntity> findByName(String name);

    CategoryEntity update(CategoryEntity categoryEntity);

    void deleteById (Long id);
}
