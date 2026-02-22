package com.example.demo.common.service;

import com.example.demo.common.dto.StudentReq;
import com.example.demo.common.dto.StudentRes;
import com.example.demo.common.entity.StudentEntity;
import com.example.demo.common.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public void saveStudent(StudentReq studentReq) {
        StudentEntity studentEntity = new StudentEntity();

        if (studentReq.getId() != null) {
            studentEntity.setId(studentReq.getId());
        }
        studentEntity.setName(studentReq.getName());
        studentEntity.setStudent_id(studentReq.getStudentId());
        studentEntity.setAge(studentReq.getAge());
        studentEntity.setBranch(studentReq.getBranch());
        studentEntity.setYear(studentReq.getYear());
        studentEntity.setHeight(studentReq.getHeight());
        studentEntity.setWeight(studentReq.getWeight());

        studentRepository.save(studentEntity);
    }

    public List<StudentRes> findAll(){
        List<StudentRes> studentResList = new ArrayList<>();
        List<StudentEntity> studentEntities = (List<StudentEntity>) studentRepository.findAll();
        for (int i = 0; i < studentEntities.size(); i++){
            StudentRes studentRes = new StudentRes();
            studentRes.setName(studentEntities.get(i).getName());
            studentRes.setStudentId(studentEntities.get(i).getStudent_id());
            studentRes.setAge(studentEntities.get(i).getAge());
            studentRes.setBranch(studentEntities.get(i).getBranch());
            studentRes.setYear(studentEntities.get(i).getYear());
            studentRes.setHeight(studentEntities.get(i).getHeight());
            studentRes.setWeight(studentEntities.get(i).getWeight());
            studentResList.add(studentRes);
        }
        return studentResList;
    }

    public StudentRes findById(Long id){
        StudentEntity studentEntity = studentRepository.findById(id).get();
        StudentRes studentRes = new StudentRes();
        studentRes.setName(studentEntity.getName());
        studentRes.setStudentId(studentEntity.getStudent_id());
        studentRes.setAge(studentEntity.getAge());
        studentRes.setBranch(studentEntity.getBranch());
        studentRes.setYear(studentEntity.getYear());
        studentRes.setHeight(studentEntity.getHeight());
        studentRes.setWeight(studentEntity.getWeight());
        return studentRes;
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
