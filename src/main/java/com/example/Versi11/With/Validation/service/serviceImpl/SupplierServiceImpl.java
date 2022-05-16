package com.example.Versi11.With.Validation.service.serviceImpl;

import com.example.Versi11.With.Validation.model.entity.SupplierEntity;
import com.example.Versi11.With.Validation.model.repository.SupplierRepository;
import com.example.Versi11.With.Validation.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    SupplierRepository supplierRepository;

    @Override
    public List<SupplierEntity> getAll() {
        return this.supplierRepository.findAll();
    }

    @Override
    public SupplierEntity save(SupplierEntity supplierEntity) {
        return this.supplierRepository.save(supplierEntity);
    }

    @Override
    public SupplierEntity findById(Long id) {
        Optional<SupplierEntity> supplier = this.supplierRepository.findById(id);
        if (!supplier.isPresent()){
            return null;
        }
        return supplier.get();
    }

    @Override
    public List<SupplierEntity> findByName(String name) {

        return this.supplierRepository.findByName(name);
    }

    @Override
    public SupplierEntity update(SupplierEntity supplierEntity) {

        return this.supplierRepository.save(supplierEntity);
    }

    @Override
    public void deleteById(Long id) {
        this.supplierRepository.deleteById(id);
    }
}
