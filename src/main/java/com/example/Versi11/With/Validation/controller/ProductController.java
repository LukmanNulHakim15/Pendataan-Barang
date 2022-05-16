package com.example.Versi11.With.Validation.controller;

import com.example.Versi11.With.Validation.dto.SearchData;
import com.example.Versi11.With.Validation.model.entity.ProductEntity;
import com.example.Versi11.With.Validation.model.entity.SupplierEntity;
import com.example.Versi11.With.Validation.response.CommonResponse;
import com.example.Versi11.With.Validation.response.CommonResponseGenerator;
import com.example.Versi11.With.Validation.service.serviceImpl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping (value = "/product")
public class ProductController {

    @Autowired
    ProductServiceImpl productService;

    @Autowired
    CommonResponseGenerator commonResponseGenerator;

    @GetMapping(value = "/all")
    public CommonResponse<List<ProductEntity>> getAll(){
        try {
           return this.commonResponseGenerator.successResponse(this.productService.getAll(),"Success");
        }catch (Exception e){
           return this.commonResponseGenerator.failedResponse(e.getMessage());
        }
    }

    @PostMapping(value = "/save")
    public CommonResponse<ProductEntity> save(@Valid @RequestBody ProductEntity productEntity, Errors errors){
        CommonResponse<ProductEntity> response = new CommonResponse<>();
        if(errors.hasErrors()){
            for (ObjectError error: errors.getAllErrors()){
                response.setMassage(error.getDefaultMessage());
            }
            return this.commonResponseGenerator.failedResponse(response.getMassage());
        }
        ProductEntity product = new ProductEntity();
        product.setName(productEntity.getName());
        product.setDescription(productEntity.getDescription());
        product.setPrice(productEntity.getPrice());

        return this.commonResponseGenerator.successResponse(this.productService.save(product),"Success");
    }

    @PutMapping(value = "/update")
    public CommonResponse<ProductEntity> update(@Valid @RequestBody ProductEntity productEntity, Errors errors){
     try {
            return this.commonResponseGenerator.successResponse(this.productService.update(productEntity),"Update Success");
        }catch (Exception e){
             return this.commonResponseGenerator.failedResponse(e.getMessage());
        }
    }

    @GetMapping(value = "/cari")
    public CommonResponse<ProductEntity> searchById(@RequestParam ("id") Long id){
        try {
            ProductEntity product = this.productService.findById(id);
            return this.commonResponseGenerator.successResponse(product,"Succes your search data");
        }catch (Exception e){
            return this.commonResponseGenerator.failedResponse(e.getMessage());
        }
    }

    @GetMapping(value = "/nama")
    public CommonResponse<List<ProductEntity>> searchByName(@RequestParam ("name") String name){
        try {
           return this.commonResponseGenerator.successResponse(this.productService.findByName(name),"Success search by name");
        }catch (Exception e){
            return this.commonResponseGenerator.failedResponse(e.getMessage());
        }
    }

    @DeleteMapping(value = "/delete")
    public CommonResponse<List<ProductEntity>> deleteById(@RequestParam ("id") Long id){
        try {
            this.productService.deleteById(id);
            return this.commonResponseGenerator.successResponse(this.productService.getAll(),"Delete success");
        }catch (Exception e){
            return this.commonResponseGenerator.failedResponse(e.getMessage());
        }
    }

    @PostMapping(value = "/saveById")
    public void saveById(@RequestBody SupplierEntity supplierEntity, @RequestParam ("id") Long productId){
        this.productService.addSupplier(supplierEntity, productId);
    }

    @PostMapping(value = "/cari/name")
    public CommonResponse<ProductEntity> findProductByName(@RequestBody SearchData searchData){
        try {
            return this.commonResponseGenerator.successResponse(this.productService.findProductByName(searchData.getSearchKey()),"Success");
        }catch (Exception e){
            return this.commonResponseGenerator.failedResponse(e.getMessage());
        }
    }

    @PostMapping(value = "/cari/nameLike")
    public CommonResponse<List<ProductEntity>> findByNameLike(@RequestBody SearchData searchData){
        try {
            return this.commonResponseGenerator.successResponse(this.productService.findProductByNameLike(searchData.getSearchKey()),"Search Success");
        }catch (Exception e){
            return  this.commonResponseGenerator.failedResponse((e.getMessage()));
        }
    }


}
