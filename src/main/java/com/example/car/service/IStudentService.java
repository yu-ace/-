package com.example.car.service;

import com.example.car.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudentService {
    void newStudent(String name);
    Page<Student> getStudentList(Pageable pageable);
    List<Student> getStudentByStatus(String status);
    void addGrade(int id,int n ,int grade);
}
