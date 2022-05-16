package com.example.Versi11.With.Validation.model.repository;

import com.example.Versi11.With.Validation.model.entity.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SupplierRepository extends JpaRepository<SupplierEntity, Long> {

    List<SupplierEntity> findByName(String name);
}
