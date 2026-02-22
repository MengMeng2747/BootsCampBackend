package com.example.demo.common.entity;

import jakarta.persistence.*;
import org.springframework.http.ResponseEntity;

import java.sql.ConnectionBuilder;

@Entity
@Table(name = "product", schema = "public")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;

    @Column(name = "product_code")
    private String productCode;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "price")
    private Float price;

    @Column(name = "stock")
    private String stock;

    @Column(name = "status")
    private String status;

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
    public String getProductCode() {
        return productCode;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getProductName() {
        return productName;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
    public Float getPrice() {
        return price;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }
    public String getStock() {
        return stock;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }
}
