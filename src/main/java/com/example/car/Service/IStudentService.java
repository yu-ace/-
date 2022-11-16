package com.example.car.Service;

import com.example.car.model.Student;

import java.util.List;

public interface IStudentService {
    void newStudent(String name);
    void addGrade(int id,String number,int grade);
    List<Student> getStudentList();
}
