package com.example.demo.common.controller;

import com.example.demo.common.dto.ProductReq;
import com.example.demo.common.dto.ProductRes;
import com.example.demo.common.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gg")
public class ProductController {
    private  final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping("/product")
    public ResponseEntity<Void> create(@RequestBody ProductReq product){
        productService.saveProduct(product);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductRes>> getAll(){
        List<ProductRes> productResList = productService.findAll();
        return ResponseEntity.ok(productResList);
    }


}
