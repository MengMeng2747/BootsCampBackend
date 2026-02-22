package com.example.demo.common.controller;

import com.example.demo.common.dto.StudentReq;
import com.example.demo.common.dto.StudentRes;
import com.example.demo.common.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private  final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public ResponseEntity<Void> create(@RequestBody StudentReq studentReq){
        studentService.saveStudent(studentReq);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<StudentRes>> getAll(){
        List<StudentRes> studentResList = studentService.findAll();
        return ResponseEntity.ok(studentResList);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody StudentReq studentReq) {
        studentReq.setId(id); // บังคับเซ็ต ID จาก URL ลงใน Request
        studentService.saveStudent(studentReq);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }

}


