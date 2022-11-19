package com.example.car.dao;

import com.example.car.model.ExamRecords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IExamRecordsDao extends JpaRepository<ExamRecords,Integer> {

    List<ExamRecords> findByStudentId(int id);

}
