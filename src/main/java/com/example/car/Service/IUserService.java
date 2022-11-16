package com.example.car.Service;

import com.example.car.model.User;

import java.util.List;

public interface IUserService {
    void register(String name,String password);
    User getUser(String name);
    List<User> getUserList();
    User getUserById(int id);
    void changePassword(int id,String password);
    void deleteUser(int id);

}
