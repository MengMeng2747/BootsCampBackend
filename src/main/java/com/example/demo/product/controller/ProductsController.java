package com.example.demo.product.controller;

import com.example.demo.product.dto.ShopproductReq;
import org.springframework.web.bind.annotation.CrossOrigin; //ตัวเชื่อม import เข้ามา
import com.example.demo.product.dto.ProductsReq;
import com.example.demo.product.dto.ProductsRes;
import com.example.demo.product.service.ProductsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173") //ตัวเชื่อม
@RestController
@RequestMapping("/api/products")
public class ProductsController {

    private final ProductsService productsService;

    public ProductsController(ProductsService productsService){
        this.productsService = productsService;
    }

    // =========================
    // POST (Create / Update ใช้ save ตัวเดียวกัน)
    // =========================
    @PostMapping("/create")
    public void saveProduct(@RequestBody ProductsReq productsReq){
        productsService.saveProduct(productsReq);
    }

    // =========================
    // GET ALL
    // =========================
    @GetMapping("/getall")
    public List<ProductsRes> findAll(){
        return productsService.findAll();
    }

    // =========================
    // GET BY ID
    // =========================
    @GetMapping("/{id}")
    public ProductsRes findById(@PathVariable Long id){
        return productsService.findById(id);
    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable Long id,
                              @RequestBody ProductsReq productsReq){
        productsService.updateProduct(id, productsReq);
    }

    // =========================
    // DELETE
    // =========================
    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long id){
        productsService.deleteProduct(id);
    }


    @PostMapping("/sell")
    public void buyProduct(@RequestBody ShopproductReq shopproductReq){
        String result = productsService.buyProduct(shopproductReq);
        ProductsService.buyProduct(shopproductReq);
    }
}