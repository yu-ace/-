package com.example.car.dao;

import com.example.car.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class StudentDao {

    @Autowired
    ConnectionPool connectionPool;


    public void newStudent(String name){
        try {
            String str = "insert into studentList (name,date,is_passed) values ('%s',curdate(),'%s');";
            String a = "未毕业";
            String sqlStr = String.format(str,name,a);
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStr);
            preparedStatement.execute();
            connectionPool.returnConnection(connection);

            String str1 = "insert into student (name) values ('%s');";
            String sqlStr1 = String.format(str1,name);
            Connection connection1 = connectionPool.getConnection();
            PreparedStatement preparedStatement1 = connection1.prepareStatement(sqlStr1);
            preparedStatement1.execute();
            connectionPool.returnConnection(connection1);
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
            //将对应的考试次数+1
            switch(number){
                case "class1Grade":
                    String str1 = "update student set class1Number = class1Number + 1 where id = %d;";
                    String sqlStr1 = String.format(str1,id);
                    Connection connection1 = connectionPool.getConnection();
                    PreparedStatement preparedStatement1 = connection1.prepareStatement(sqlStr1);
                    preparedStatement1.execute();
                    connectionPool.returnConnection(connection1);
                    break;
                case "class2Grade":
                    String str2 = "update student set class2Number = class2Number + 1 where id = %d;";
                    String sqlStr2 = String.format(str2,id);
                    Connection connection2 = connectionPool.getConnection();
                    PreparedStatement preparedStatement2 = connection2.prepareStatement(sqlStr2);
                    preparedStatement2.execute();
                    connectionPool.returnConnection(connection2);
                    break;
                case "class3Grade":
                    String str3 = "update student set class3Number = class3Number + 1 where id = %d;";
                    String sqlStr3 = String.format(str3,id);
                    Connection connection3 = connectionPool.getConnection();
                    PreparedStatement preparedStatement3 = connection3.prepareStatement(sqlStr3);
                    preparedStatement3.execute();
                    connectionPool.returnConnection(connection3);
                    break;
                case "class4Grade":
                    String str4 = "update student set class4Number = class4Number + 1 where id = %d;";
                    String sqlStr4 = String.format(str4,id);
                    Connection connection4 = connectionPool.getConnection();
                    PreparedStatement preparedStatement4 = connection4.prepareStatement(sqlStr4);
                    preparedStatement4.execute();
                    connectionPool.returnConnection(connection4);
                    break;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Student> studentGradeList(){
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
                int class1Number = resultSet.getInt("class1Number");
                int class2Number = resultSet.getInt("class2Number");
                int class3Number = resultSet.getInt("class3Number");
                int class4Number = resultSet.getInt("class4Number");
                Student student = new Student();
                student.setId(id);
                student.setName(name);
                student.setClass1Grade(class1Grade);
                student.setClass2Grade(class2Grade);
                student.setClass3Grade(class3Grade);
                student.setClass4Grade(class4Grade);
                student.setClass1Number(class1Number);
                student.setClass2Number(class2Number);
                student.setClass3Number(class3Number);
                student.setClass4Number(class4Number);
                studentList.add(student);
            }
            connectionPool.returnConnection(connection);
            return studentList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Student> studentGradeListPassed(){
        try {
            String sqlStr = "select * from student where (class1Grade >= 90 and class2Grade >= 90 " +
                    "and class3Grade >= 90 and class4Grade >= 90);";
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStr);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Student> studentPassedList = new ArrayList<>();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Student student = new Student();
                student.setId(id);
                student.setName(name);
                studentPassedList.add(student);
            }
            connectionPool.returnConnection(connection);
            return studentPassedList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void changePassed(int id){
        try {
            String str = "update studentList set is_passed = '%s' where id = %d;";
            String a = "已毕业";
            String mqlStr = String.format(str,a,id);
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(mqlStr);
            preparedStatement.execute();
            connectionPool.returnConnection(connection);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Student> studentList(){
        try {
            String sqlStr = "select * from studentList;";
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStr);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Student> studentList = new ArrayList<>();
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Date time = resultSet.getDate("date");
                String passed = resultSet.getString("is_passed");
                Student student = new Student();
                student.setId(id);
                student.setName(name);
                student.setJoinTime(time);
                student.setIsPassed(passed);
                studentList.add(student);
            }
            connectionPool.returnConnection(connection);
            return studentList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Student> getStudentByStatus(String status){
        try {
            String str = "select * from studentList where is_passed = '%s';";
            String sqlStr = String.format(str,status);
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStr);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Student> students = new ArrayList<>();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Date date = resultSet.getDate("date");
                String passed = resultSet.getString("is_passed");
                Student student = new Student();
                student.setId(id);
                student.setName(name);
                student.setJoinTime(date);
                student.setIsPassed(passed);
                students.add(student);
            }
            connectionPool.returnConnection(connection);
            return students;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
