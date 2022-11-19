package com.example.car.service;

import com.example.car.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService {
    void register(String name,String password);
    User getUser(String name);
    List<User> getUserList();
    User getUserById(int id);
    void changePassword(int id,String password);
    void deleteUser(int id);

}
