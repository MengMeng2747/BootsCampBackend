package com.example.demo.dto;

public class ShopReq {

    // --- โซนประกาศตัวแปร (Attributes) ---
    // ใช้ private เพื่อซ่อนข้อมูล ไม่ให้ภายนอกเข้าถึงโดยตรง (Encapsulation)
    private Integer id;       // รหัสร้านค้า (อาจจะไม่ต้องส่งมาถ้าเป็นการสร้างใหม่)
    private String name;      // ชื่อร้านค้า
    private Boolean active;   // สถานะการเปิดใช้งาน
    private String zone;      // โซนที่ตั้งร้าน
    private String remark;    // หมายเหตุ

    // --- โซน Getter และ Setter (Methods) ---
    // เนื่องจากตัวแปรข้างบนเป็น private เราต้องสร้างประตูทางเข้า-ออก ให้ข้อมูล

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }

    // -----------------------------------------------------------

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    // -----------------------------------------------------------

    public void setActive(Boolean active) {
        this.active = active;
    }
    public Boolean getActive() {
        return active;
    }

    // -----------------------------------------------------------

    public void setZone(String zone) {
        this.zone = zone;
    }
    public String getZone() {
        return zone;
    }

    // -----------------------------------------------------------

    public void setRemark(String remark) {
        this.remark = remark;
    }
    public String getRemark() {
        return remark;
    }
}