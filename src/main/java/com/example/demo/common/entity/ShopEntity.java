package com.example.demo.common.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "shop", schema = "public")
public class ShopEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "zone")
    private String zone;

    @Column(name = "remark")
    private String remark;

    // คง method นี้ไว้ตามรูปแบบที่คุณต้องการ
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
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    //-----------------------------------------------------------
    public void setActive(Boolean active) {
        this.active = active;
    }
    public Boolean getActive() {
        return active;
    }
    //-----------------------------------------------------------
    public void setZone(String zone) {
        this.zone = zone;
    }
    public String getZone() {
        return zone;
    }
    //-----------------------------------------------------------
    public void setRemark(String remark) {
        this.remark = remark;
    }
    public String getRemark() {
        return remark;
    }
}