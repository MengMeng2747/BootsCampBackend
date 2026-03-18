package com.example.demo.bootscamp.dto.Res;

import java.math.BigDecimal;

public class ResellerOrderRes {

    private Integer orderId;
    private String customerName;
    private String productName;
    private Integer quantity;
    private BigDecimal sellingPrice;
    private String status;

    public ResellerOrderRes() {}

    public ResellerOrderRes(Integer orderId,
                            String customerName,
                            String productName,
                            Integer quantity,
                            BigDecimal sellingPrice,
                            String status) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.productName = productName;
        this.quantity = quantity;
        this.sellingPrice = sellingPrice;
        this.status = status;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getProductName() {
        return productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public BigDecimal getSellingPrice() {
        return sellingPrice;
    }

    public String getStatus() {
        return status;
    }
}