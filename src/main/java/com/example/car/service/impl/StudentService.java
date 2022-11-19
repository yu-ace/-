package com.example.car.service.impl;

import com.example.car.dao.IStudentDao;
import com.example.car.service.IStudentService;
import com.example.car.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StudentService implements IStudentService {

    @Autowired
    IStudentDao studentDao;

    @Override
    public void newStudent(String name) {
        Student student = new Student();
        student.setName(name);
        student.setJoinTime(new Date());
        student.setIsPassed("未毕业");
        studentDao.save(student);
    }

    @Override
    public Page<Student> getStudentList(Pageable pageable){
        return studentDao.findAll(pageable);
    }

    @Override
    public List<Student> getStudentByStatus(String status){
        return studentDao.findByIsPassed(status);
    }

    @Override
    public void addGrade(int id, int n, int grade) {
        Student student = studentDao.findById(id);
        switch(n){
            case 1:
                student.setClass1Grade(grade);
                break;
            case 2:
                student.setClass2Grade(grade);
                break;
            case 3:
                student.setClass3Grade(grade);
                break;
            case 4:
                student.setClass4Grade(grade);
                break;
        }
        if(student.getClass1Grade() >= 90 && student.getClass2Grade() >= 90
                && student.getClass3Grade() >= 90 && student.getClass4Grade() >= 90){
            student.setIsPassed("已毕业");
        }else{
            student.setIsPassed("未毕业");
        }
        studentDao.save(student);
    }


}
