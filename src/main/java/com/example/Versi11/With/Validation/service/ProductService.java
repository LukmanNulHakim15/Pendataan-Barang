package com.example.Versi11.With.Validation.service;

import com.example.Versi11.With.Validation.model.entity.ProductEntity;

import java.util.List;

public interface ProductService {

     List<ProductEntity> getAll();

     ProductEntity save(ProductEntity productEntity);

     ProductEntity findById (Long id);

     List<ProductEntity> findByName (String name);

     ProductEntity update(ProductEntity productEntity);

     void deleteById (Long id);

     ProductEntity findProductByName (String name);

     List<ProductEntity> findProductByNameLike (String name);



}
