package com.example.demo.common.service;

import com.example.demo.common.dto.ProductReq;
import com.example.demo.common.dto.ProductRes;
import com.example.demo.common.entity.ProductEntity;
import com.example.demo.common.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void saveProduct(ProductReq product) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setProductCode(product.getProductCode());
        productEntity.setProductName(product.getProductName());
        productEntity.setPrice(product.getPrice());
        productEntity.setStock(product.getStock());
        productEntity.setStatus(product.getStatus());
        productRepository.save(productEntity);

//        System.out.println(); คำสั่งในการ run คำสั่ง sout
    }

    public List<ProductRes> findAll() {
        List<ProductRes> productResList = new ArrayList<>();
        List<ProductEntity> productEntities = (List<ProductEntity>) productRepository.findAll();
        for (int i = 0; i < productEntities.size(); i++) {
            ProductRes productRes = new ProductRes();
            productRes.setProductName(productEntities.get(i).getProductName());
            productRes.setProductCode(productEntities.get(i).getProductCode());
            productRes.setPrice(productEntities.get(i).getPrice());
            productRes.setStock(productEntities.get(i).getStock());
            productRes.setStatus(productEntities.get(i).getStatus());
            productResList.add(productRes);
        }
        return productResList;
    }
}