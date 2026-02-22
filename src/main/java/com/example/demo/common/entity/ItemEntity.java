package com.example.demo.common.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "item", schema = "public")
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Integer id;

    @Column(name = "shop_id")
    private Integer shopId;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Integer price;

    @Column(name = "qty")
    private Integer qty;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "category")
    private String category;

    @Column(name = "model")
    private String model;

    public static List<Object> findByid(Long id) {
        return null;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }
    //-----------------------------------------------------------
    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }
    public Integer getShopId() {
        return shopId;
    }
    //-----------------------------------------------------------
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    //-----------------------------------------------------------
    public void setPrice(Integer price) {
        this.price = price;
    }
    public Integer getPrice() {
        return price;
    }
    //-----------------------------------------------------------
    public void setQty(Integer qty) {
        this.qty = qty;
    }
    public Integer getQty() {
        return qty;
    }
    //-----------------------------------------------------------
    public void setActive(Boolean active) {
        this.active = active;
    }
    public Boolean getActive() {
        return active;
    }
    //-----------------------------------------------------------
    public void setCategory(String category) {
        this.category = category;
    }
    public String getCategory() {
        return category;
    }
    //-----------------------------------------------------------
    public void setModel(String model) {
        this.model = model;
    }
    public String getModel() {
        return model;
    }
}