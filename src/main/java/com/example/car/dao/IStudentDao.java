package com.example.car.dao;

import com.example.car.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStudentDao extends JpaRepository<Student,Integer> {

    Student findById(int id);

    List<Student> findByIsPassed(String status);

}
