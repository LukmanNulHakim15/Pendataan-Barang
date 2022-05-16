package com.example.Versi11.With.Validation.service.serviceImpl;

import com.example.Versi11.With.Validation.model.entity.CategoryEntity;
import com.example.Versi11.With.Validation.model.repository.CategoryRepository;
import com.example.Versi11.With.Validation.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<CategoryEntity> findAll() {
        return this.categoryRepository.findAll();
    }

    @Override
    public CategoryEntity save(CategoryEntity categoryEntity) {
        return this.categoryRepository.save(categoryEntity);
    }

    @Override
    public CategoryEntity findById(Long id) {
        Optional<CategoryEntity> category = this.categoryRepository.findById(id);
        if(!category.isPresent()){
            return null;
        }
        return category.get();
    }

    @Override
    public List<CategoryEntity> findByName(String name) {
        return this.categoryRepository.findByName(name);
    }

    @Override
    public CategoryEntity update(CategoryEntity categoryEntity) {
        return this.categoryRepository.save(categoryEntity);
    }

    @Override
    public void deleteById(Long id) {
      this.categoryRepository.deleteById(id);
    }
}
