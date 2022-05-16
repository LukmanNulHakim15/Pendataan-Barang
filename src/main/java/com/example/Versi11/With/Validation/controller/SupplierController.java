package com.example.Versi11.With.Validation.controller;

import com.example.Versi11.With.Validation.dto.SupplierData;
import com.example.Versi11.With.Validation.model.entity.SupplierEntity;
import com.example.Versi11.With.Validation.model.repository.SupplierRepository;
import com.example.Versi11.With.Validation.response.CommonResponse;
import com.example.Versi11.With.Validation.response.CommonResponseGenerator;
import com.example.Versi11.With.Validation.service.serviceImpl.SupplierServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/supplier")
public class SupplierController {

    @Autowired
    SupplierServiceImpl supplierServiceImpl;

    @Autowired
    CommonResponseGenerator commonResponseGenerator;

    @PostMapping(value = "/save")
    public CommonResponse<SupplierEntity> save(@Valid @RequestBody SupplierData supplierData, Errors errors){
        CommonResponse<SupplierEntity> response = new CommonResponse<>();
        if (errors.hasErrors()){
            for(ObjectError error : errors.getAllErrors()){
                response.setMassage(error.getDefaultMessage());
            }
            return this.commonResponseGenerator.failedResponse(response.getMassage());
        }

        SupplierEntity supplier = new SupplierEntity();
        supplier.setName(supplierData.getName());
        supplier.setAddress(supplierData.getAddress());
        supplier.setEmail(supplierData.getEmail());

        return this.commonResponseGenerator.successResponse(this.supplierServiceImpl.save(supplier),"Success save data");
    }

    @GetMapping(value = "/all")
    public CommonResponse<List<SupplierEntity>> getAll(){
        try {
            return this.commonResponseGenerator.successResponse(this.supplierServiceImpl.getAll(),"Success get all data");
        }catch (Exception e){
            return this.commonResponseGenerator.failedResponse(e.getMessage());
        }
    }

    @GetMapping(value = "/searchById")
    public CommonResponse<SupplierEntity> getById(@RequestParam ("id") Long id){
        try {
            SupplierEntity supplier = this.supplierServiceImpl.findById(id);
            return this.commonResponseGenerator.successResponse(supplier,"Success your search by id");
        }catch (Exception e){
            return this.commonResponseGenerator.failedResponse(e.getMessage());
        }
    }

    @GetMapping(value = "/searchByName")
    public CommonResponse<List<SupplierEntity>> getByName(@RequestParam ("name") String name){
        try {
            return this.commonResponseGenerator.successResponse(this.supplierServiceImpl.findByName(name),"Success your search by name");
        }catch (Exception e){
            return this.commonResponseGenerator.failedResponse(e.getMessage());
        }

    }

    @PutMapping(value = "/edit")
    public CommonResponse<SupplierEntity> edit(@Valid @RequestBody SupplierEntity supplierEntity, Errors errors){
        CommonResponse<SupplierEntity> response = new CommonResponse<>();
        if(errors.hasErrors()){
            for(ObjectError error : errors.getAllErrors()){
                response.setMassage(error.getDefaultMessage());
            }
            return this.commonResponseGenerator.failedResponse(response.getMassage());
        }

        SupplierEntity supplier = new SupplierEntity();
        supplier.setName(supplierEntity.getName());
        supplier.setAddress(supplierEntity.getAddress());
        supplier.setEmail(supplierEntity.getEmail());

        return this.commonResponseGenerator.successResponse(this.supplierServiceImpl.save(supplier),"Edit success");
    }

    @DeleteMapping(value = "/delete")
    public CommonResponse<List<SupplierEntity>> deleteById(@RequestParam ("id") Long id){
        try {
            this.supplierServiceImpl.deleteById(id);
            return this.commonResponseGenerator.successResponse(this.supplierServiceImpl.getAll(),"Delete success");
        }catch (Exception e){
            return this.commonResponseGenerator.failedResponse(e.getMessage());
        }
    }

}
