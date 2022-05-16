package com.example.Versi11.With.Validation.controller;

import com.example.Versi11.With.Validation.model.entity.CategoryEntity;
import com.example.Versi11.With.Validation.response.CommonResponse;
import com.example.Versi11.With.Validation.response.CommonResponseGenerator;
import com.example.Versi11.With.Validation.service.serviceImpl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    CategoryServiceImpl categoryService;

    @Autowired
    CommonResponseGenerator commonResponseGenerator;

    @GetMapping(value = "/all")
    public CommonResponse<List<CategoryEntity>> findAll(){
        try {
            return this.commonResponseGenerator.successResponse(this.categoryService.findAll(),"Success");
        }catch (Exception e){
            return this.commonResponseGenerator.failedResponse(e.getMessage());
        }
    }

    @PostMapping(value = "/save")
    public CommonResponse<CategoryEntity> save(@RequestBody CategoryEntity categoryEntity){
        try {
            CategoryEntity category = this.categoryService.save(categoryEntity);
            return this.commonResponseGenerator.successResponse(category,"Success save");
        }catch (Exception e){
            return this.commonResponseGenerator.failedResponse(e.getMessage());
        }
    }

    @GetMapping(value = "/searchId")
    public CommonResponse<CategoryEntity> findById(@RequestParam ("id") Long id){
        try {
            CategoryEntity category = this.categoryService.findById(id);
            return this.commonResponseGenerator.successResponse(category,"Success search by id");
        }catch (Exception e){
            return this.commonResponseGenerator.failedResponse(e.getMessage());
        }
    }

    @GetMapping(value = "/searchName")
    public CommonResponse<List<CategoryEntity>> findByName(@RequestParam ("name") String name){
        try {
            return this.commonResponseGenerator.successResponse(this.categoryService.findByName(name),"Success search by name");
        }catch (Exception e){
            return this.commonResponseGenerator.failedResponse(e.getMessage());
        }
    }

    @GetMapping(value = "/update")
    public CommonResponse<CategoryEntity> update(CategoryEntity categoryEntity){
        try {
            CategoryEntity category = this.categoryService.update(categoryEntity);
            return this.commonResponseGenerator.successResponse(category,"Success update data");
        }catch (Exception e){
            return this.commonResponseGenerator.failedResponse(e.getMessage());
        }
    }

    @DeleteMapping(value = "/delete")
    public void delete(@RequestParam ("id") Long id) {
        try {
            this.categoryService.deleteById(id);
            this.commonResponseGenerator.successResponse(this.categoryService.findAll(), "Success data delete");
        } catch (Exception e) {
             this.commonResponseGenerator.failedResponse(e.getMessage());
        }
    }
}
