package com.example.car.dao;

import com.example.car.model.Subjects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;

@Repository
public interface ISubjects extends JpaRepository<Subjects,Integer> {
}
