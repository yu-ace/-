package com.example.car.dao;

import com.example.car.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class StudentDao {

    @Autowired
    ConnectionPool connectionPool;

    public void newStudent(String name){
        try {
            String str = "insert into student (name,gender) values ('%s');";
            String sqlStr = String.format(str,name);
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStr);
            preparedStatement.execute();
            connectionPool.returnConnection(connection);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void addGrade(int id,String number,int grade){
        try {
            String str = "update student set %s = %d where id = %d;";
            String sqlStr = String.format(str,number,grade,id);
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStr);
            preparedStatement.execute();
            connectionPool.returnConnection(connection);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Student> getStudentList(){
        try {
            String sqlStr = "select * from student;";
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStr);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Student> studentList = new ArrayList<>();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int class1Grade = resultSet.getInt("class1Grade");
                int class2Grade = resultSet.getInt("class2Grade");
                int class3Grade = resultSet.getInt("class3Grade");
                int class4Grade = resultSet.getInt("class4Grade");
                Student student = new Student();
                student.setId(id);
                student.setName(name);
                student.setClass1Grade(class1Grade);
                student.setClass2Grade(class2Grade);
                student.setClass3Grade(class3Grade);
                student.setClass4Grade(class4Grade);
                studentList.add(student);
            }
            connectionPool.returnConnection(connection);
            return studentList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
