package com.example.Versi11.With.Validation.service.serviceImpl;

import com.example.Versi11.With.Validation.model.entity.ProductEntity;
import com.example.Versi11.With.Validation.model.entity.SupplierEntity;
import com.example.Versi11.With.Validation.model.repository.ProductRepository;
import com.example.Versi11.With.Validation.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepo;

    @Override
    public List<ProductEntity> getAll() {

        return this.productRepo.findAll();
    }

    @Override
    public ProductEntity save(ProductEntity productEntity) {

        return this.productRepo.save(productEntity);
    }

    @Override
    public ProductEntity findById(Long id) {
        Optional<ProductEntity> product =this.productRepo.findById(id);
        if (!product.isPresent()){
            return null;
        }
        return product.get();
    }

    @Override
    public List<ProductEntity> findByName(String name) {

        return this.productRepo.findByName(name);
    }

    @Override
    public ProductEntity update(ProductEntity productEntity) {

        return this.productRepo.save(productEntity);
    }

    @Override
    public void deleteById(Long id) {
        this.productRepo.deleteById(id);
    }

    @Override
    public ProductEntity findProductByName(String name) {

        return this.productRepo.findProductByName(name);
    }

    @Override
    public List<ProductEntity> findProductByNameLike(String name) {
        return this.productRepo.findProductByNameLike("%"+name+"%");
    }

    public void addSupplier(SupplierEntity supplierEntity, Long productId){
        ProductEntity productEntity = findById(productId);
        if (productEntity == null){
            throw new RuntimeException("Product with ID : "+productId+" not found");
        }
        productEntity.getSupplier().add(supplierEntity);
        save(productEntity);
    }



//    public void addCategory(CategoryEntity categoryEntity, Long id){
//        ProductEntity productEntity = findById(id);
//        if (productEntity == null){
//            throw new RuntimeException("Product with id : " +id+ "not found");
//        }
//        productEntity.get
//    }
}
