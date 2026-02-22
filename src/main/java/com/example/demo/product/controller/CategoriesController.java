package com.example.demo.product.controller;


import com.example.demo.product.dto.CategoriesReq;
import com.example.demo.product.dto.CategoriesRes;
import com.example.demo.product.dto.ShopproductReq;
import com.example.demo.product.service.CategoriesService;
import com.example.demo.product.service.ProductsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {

    private final CategoriesService categoriesService;

    public CategoriesController(CategoriesService categoriesService){
        this.categoriesService = categoriesService;
    }

    // =========================
    // POST (CREATE)
    // =========================
    @PostMapping("/create")
    public void saveCategory(@RequestBody CategoriesReq categoriesReq){
        categoriesService.saveCategory(categoriesReq);
    }

    // =========================
    // GET ALL
    // =========================
    @GetMapping("/getall")
    public List<CategoriesRes> findAll(){
        return categoriesService.findAll();
    }

    // =========================
    // GET BY ID
    // =========================
    @GetMapping("/{id}")
    public CategoriesRes findById(@PathVariable Long id){
        return categoriesService.findById(id);
    }

    // =========================
    // PUT (UPDATE)
    // =========================
    @PutMapping("/{id}")
    public void updateCategory(@PathVariable Long id,
                               @RequestBody CategoriesReq categoriesReq){
        categoriesService.updateCategory(id, categoriesReq);
    }

    // =========================
    // DELETE
    // =========================
    @DeleteMapping("/delete/{id}")
    public void deleteCategory(@PathVariable Long id){
        categoriesService.deleteCategory(id);
    }

}