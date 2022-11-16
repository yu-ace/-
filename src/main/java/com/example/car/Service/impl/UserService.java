package com.example.car.Service.impl;

import com.example.car.Service.IUserService;
import com.example.car.dao.UserDao;
import com.example.car.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}
