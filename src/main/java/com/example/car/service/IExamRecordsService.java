package com.example.car.service;

import com.example.car.model.ExamRecords;
import com.example.car.service.impl.ExamRecordsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IExamRecordsService {
    void addGrade(int id,int n,int grade);
    List<ExamRecords> getExamRecordsByStudentId(int id);
    Page<ExamRecords> getExamRecords(Pageable pageable);
}
