package com.example.car.dao;

import com.example.car.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDao {

    @Autowired
    ConnectionPool connectionPool;


    public void register(String name,String password){
        try {
            String str = "insert into user (name,password) values ('%s','%s');";
            String sqlStr = String.format(str,name,password);
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStr);
            preparedStatement.execute();
            connectionPool.returnConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public User getUser(String name){
        try {
            String str = "select * from user where (name = '%s' and isDelete = 0);";
            String sqlStr = String.format(str,name);
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStr);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(!resultSet.next()){
                return null;
            }
            int id = resultSet.getInt("id");
            String name1 = resultSet.getString("name");
            String password = resultSet.getString("password");
            User user = new User();
            user.setId(id);
            user.setName(name1);
            user.setPassword(password);
            connectionPool.returnConnection(connection);
            return user;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getUserList(){
        try {
            String sqlStr = "select * from user where isDelete = 0;";
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStr);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<User> userList = new ArrayList<>();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String password = resultSet.getString("password");
                User user = new User();
                user.setId(id);
                user.setName(name);
                user.setPassword(password);
                userList.add(user);
            }
            connectionPool.returnConnection(connection);
            return userList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public User getUserById(int id){
        try {
            String str = "select * from user where (id = %d and isDelete = 0);";
            String sqlStr = String.format(str,id);
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStr);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(!resultSet.next()){
                return null;
            }
            int id1 = resultSet.getInt("id");
            String name1 = resultSet.getString("name");
            String password = resultSet.getString("password");
            User user = new User();
            user.setId(id1);
            user.setName(name1);
            user.setPassword(password);
            connectionPool.returnConnection(connection);
            return user;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void changePassword(int id,String password){
        try {
            String str = "update user set password = '%s' where (id = %d and isDelete = 0);";
            String sqlStr = String.format(str,password,id);
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStr);
            preparedStatement.execute();
            connectionPool.returnConnection(connection);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void deleteUser(int id){
        try {
            String str = "update user set isDelete = 1 where id = %d;";
            String sqlStr = String.format(str,id);
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStr);
            preparedStatement.execute();
            connectionPool.returnConnection(connection);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
