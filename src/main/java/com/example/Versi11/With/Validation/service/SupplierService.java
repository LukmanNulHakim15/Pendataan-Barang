package com.example.Versi11.With.Validation.service;

import com.example.Versi11.With.Validation.model.entity.SupplierEntity;

import java.util.List;

public interface SupplierService {

    List<SupplierEntity> getAll();

    SupplierEntity save(SupplierEntity supplierEntity);

    SupplierEntity findById(Long id);

    List<SupplierEntity> findByName(String name);

    SupplierEntity update(SupplierEntity supplierEntity);

    void deleteById(Long id);
}
