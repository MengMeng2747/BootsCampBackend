package com.example.demo.common.dto;

public class StudentReq {
    private Long id;
    private String name;
    private String studentId;
    private Integer age;
    private String branch;
    private String year;
    private String height;
    private String weight;

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
    //    ----------------------------------------------------------
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    //    ----------------------------------------------------------
    public void setStudentId(String studentId){
        this.studentId = studentId;
    }
    public String getStudentId(){
        return studentId;
    }
    //    ----------------------------------------------------------
    public void setAge(Integer age) {
        this.age = age;
    }
    public Integer getAge() {
        return age;
    }
    //        ----------------------------------------------------------
    public void setBranch(String branch) {
        this.branch = branch;
    }
    public String getBranch() {
        return branch;
    }
    //        ----------------------------------------------------------
    public void setYear(String year){
        this.year = year;
    }
    public String getYear(){
        return year;
    }
    //    ----------------------------------------------------------
    public void setHeight(String height){
        this.height = height;
    }
    public String getHeight() {
        return height;
    }
    //    ----------------------------------------------------------
    public void setWeight(String weight) {
        this.weight = weight;
    }
    public String getWeight() {
        return weight;
    }
    //    ----------------------------------------------------------
}
