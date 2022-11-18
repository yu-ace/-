package com.example.car.service.impl;

import com.example.car.service.IUserService;
import com.example.car.dao.UserDao;
import com.example.car.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    UserDao userDao;

    @Override
    public void register(String name, String password) {
        userDao.register(name,password);
    }

    @Override
    public User getUser(String name) {
        return userDao.getUser(name);
    }

    @Override
    public List<User> getUserList() {
        return userDao.getUserList();
    }

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public void changePassword(int id,String password) {
        userDao.changePassword(id,password);
    }

    @Override
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }




}
