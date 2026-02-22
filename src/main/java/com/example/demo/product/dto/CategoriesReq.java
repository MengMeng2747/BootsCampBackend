package com.example.demo.product.dto;

import java.math.BigDecimal;

public class CategoriesReq {
    private Long id;
    private String name;
    private String description;

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
}
