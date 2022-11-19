package com.example.car.service.impl;

import com.example.car.service.IStudentService;
import com.example.car.dao.StudentDao;
import com.example.car.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<Student> getStudentGradeList() {
        return studentDao.studentGradeList();
    }

    @Override
    public List<Student> getStudentList() {
        return studentDao.studentList();
    }

    @Override
    public void changePassed() {
        List<Student> studentList = studentDao.studentGradeListPassed();
        for(Student student : studentList){
            studentDao.changePassed(student.getId());
        }
    }

    @Override
    public List<Student> getStudentByPassed(String status){
        return studentDao.getStudentByStatus(status);
    }

}
