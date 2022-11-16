package com.example.car.Service.impl;

import com.example.car.Service.IStudentService;
import com.example.car.dao.StudentDao;
import com.example.car.model.Student;
import com.example.car.model.User;
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
        List<Student> studentList = studentDao.studentGradeList();
        List<Student> students = new ArrayList<>();
        for(Student student : studentList){
            if(student.getClass1Grade() >= 90
                    && student.getClass2Grade() >= 90
                    && student.getClass3Grade() >= 90
                    && student.getClass4Grade() >= 90){
                students.add(student);
            }
        }
        for(Student student : students){
            studentDao.changePassed(student.getId());
        }
    }

    @Override
    public List<Student> getStudentByPassed(String status){
        return studentDao.getStudentByStatus(status);
    }

}
