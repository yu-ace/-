package com.example.car.service.impl;

import com.example.car.dao.IUserDao;
import com.example.car.service.IUserService;
import com.example.car.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserDao userDao;

    @Override
    public void register(String name, String password) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setIsDelete(0);
        userDao.save(user);
    }

    @Override
    public User getUser(String name){
        return userDao.findByName(name);
    }

    @Override
    public List<User> getUserList() {
        return userDao.findByIsDelete(0);
    }

    @Override
    public User getUserById(int id) {
        return userDao.findById(id);
    }

    @Override
    public void changePassword(int id,String password) {
        User user = userDao.findById(id);
        user.setPassword(password);
        userDao.save(user);
    }

    @Override
    public void deleteUser(int id) {
        User user = userDao.findById(id);
        user.setIsDelete(1);
        userDao.save(user);
    }




}
