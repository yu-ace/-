package com.example.car.Service;

import com.example.car.model.User;

public interface IUserService {
    void register(String name,String password);
    User getUser(String name);
}
