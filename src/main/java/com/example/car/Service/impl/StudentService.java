package com.example.car.Service.impl;

import com.example.car.Service.IStudentService;
import com.example.car.dao.StudentDao;
import com.example.car.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {

    @Autowired
    StudentDao studentDao;

    @Override
    public void newStudent(String name) {
        studentDao.newStudent(name);
    }

    @Override
    public void addGrade(int id, String number, int grade) {
        studentDao.addGrade(id,number,grade);
    }

    @Override
    public List<Student> getStudentList() {
        return studentDao.getStudentList();
    }
}
