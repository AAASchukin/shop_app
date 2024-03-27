package com.example.shop.service;

import com.example.shop.entity.User;

import java.util.List;

public interface UserService {
    User add(User newUser);
    User getByLogin(String login);
    List<User> getByFirstNameAndLastName(String name, String surname);

}
