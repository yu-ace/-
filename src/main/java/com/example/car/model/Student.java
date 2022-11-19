package com.example.car.model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "student")
@DynamicUpdate
public class Student {
    @Id
    @Column(name = "student_id")
    int id;
    @Column(name = "name")
    String name;
    @Column(name = "join_time")
    Date joinTime;
    @Column(name = "is_passed")
    String isPassed;
    @Column(name = "class1_grade")
    int class1Grade;
    @Column(name = "class2_grade")
    int class2Grade;
    @Column(name = "class3_grade")
    int class3Grade;
    @Column(name = "class4_grade")
    int class4Grade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }

    public String getIsPassed() {
        return isPassed;
    }

    public void setIsPassed(String isPassed) {
        this.isPassed = isPassed;
    }

    public int getClass1Grade() {
        return class1Grade;
    }

    public void setClass1Grade(int class1Grade) {
        this.class1Grade = class1Grade;
    }

    public int getClass2Grade() {
        return class2Grade;
    }

    public void setClass2Grade(int class2Grade) {
        this.class2Grade = class2Grade;
    }

    public int getClass3Grade() {
        return class3Grade;
    }

    public void setClass3Grade(int class3Grade) {
        this.class3Grade = class3Grade;
    }

    public int getClass4Grade() {
        return class4Grade;
    }

    public void setClass4Grade(int class4Grade) {
        this.class4Grade = class4Grade;
    }
}
