package com.example.demo.product.dto;

import java.math.BigDecimal;

public class ShopproductReq {
    private Long idproduct;
    private String nameproduct;
    private Integer countproduct;
    private BigDecimal money;

    public Long getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(Long idproduct) {
        this.idproduct = idproduct;
    }

    public String getNameproduct() {
        return nameproduct;
    }

    public void setNameproduct(String nameproduct) {
        this.nameproduct = nameproduct;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Integer getCountproduct() {
        return countproduct;
    }

    public void setCountproduct(Integer countproduct) {
        this.countproduct = countproduct;
    }
}
