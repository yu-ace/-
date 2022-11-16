package com.example.car.model;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Student {
    int id;
    String name;
    Date joinTime;
    String isPassed;
    int class1Grade;
    int class2Grade;
    int class3Grade;
    int class4Grade;
    int class1Number;
    int class2Number;
    int class3Number;
    int class4Number;

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

    public int getClass1Number() {
        return class1Number;
    }

    public void setClass1Number(int class1Number) {
        this.class1Number = class1Number;
    }

    public int getClass2Number() {
        return class2Number;
    }

    public void setClass2Number(int class2Number) {
        this.class2Number = class2Number;
    }

    public int getClass3Number() {
        return class3Number;
    }

    public void setClass3Number(int class3Number) {
        this.class3Number = class3Number;
    }

    public int getClass4Number() {
        return class4Number;
    }

    public void setClass4Number(int class4Number) {
        this.class4Number = class4Number;
    }
}
