package com.example.demo.common.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "student", schema = "public")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "student_id")
    private String studentId;

    @Column(name = "age")
    private Integer age;

    @Column(name = "branch")
    private String branch;

    @Column(name = "year")
    private String year;

    @Column(name = "height")
    private String height;

    @Column(name = "weight")
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
    public void setStudent_id(String studentId){
        this.studentId = studentId;
    }
    public String getStudent_id(){
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
