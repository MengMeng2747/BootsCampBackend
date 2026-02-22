package com.example.demo.common.dto;

public class ItemReq {
    private Integer id;       // รหัสสินค้า
    private Integer shopId;   // รหัสร้านค้า (Foreign Key อ้างอิงตาราง Shop)
    private String name;      // ชื่อสินค้า
    private Integer price;    // ราคาสินค้า
    private Integer qty;      // จำนวนสินค้าที่มีอยู่
    private Boolean active;   // สถานะการเปิดขาย
    private String category;  // หมวดหมู่สินค้า
    private String model;     // รุ่นสินค้า

    // --- โซน Getter และ Setter (Methods) ---

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }

    // -----------------------------------------------------------

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }
    public Integer getShopId() {
        return shopId;
    }

    // -----------------------------------------------------------

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    // -----------------------------------------------------------

    public void setPrice(Integer price) {
        this.price = price;
    }
    public Integer getPrice() {
        return price;
    }

    // -----------------------------------------------------------

    public void setQty(Integer qty) {
        this.qty = qty;
    }
    public Integer getQty() {
        return qty;
    }

    // -----------------------------------------------------------

    public void setActive(Boolean active) {
        this.active = active;
    }
    public Boolean getActive() {
        return active;
    }

    // -----------------------------------------------------------

    public void setCategory(String category) {
        this.category = category;
    }
    public String getCategory() {
        return category;
    }

    // -----------------------------------------------------------

    public void setModel(String model) {
        this.model = model;
    }
    public String getModel() {
        return model;
    }
}
