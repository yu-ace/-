package com.example.car.service.impl;

import com.example.car.dao.IExamRecordsDao;
import com.example.car.model.ExamRecords;
import com.example.car.service.IExamRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ExamRecordsService implements IExamRecordsService {

    @Autowired
    IExamRecordsDao examRecordsDao;

    @Override
    public void addGrade(int id, int n, int grade) {
        ExamRecords examRecords = new ExamRecords();
        examRecords.setStudentId(id);
        examRecords.setSubjectId(n);
        examRecords.setGrade(grade);
        examRecords.setExamTime(new Date());
        examRecordsDao.save(examRecords);
    }

    @Override
    public List<ExamRecords> getExamRecordsByStudentId(int id) {
        return examRecordsDao.findByStudentId(id);
    }

    @Override
    public Page<ExamRecords> getExamRecords(Pageable pageable) {
        return examRecordsDao.findAll(pageable);
    }

}
