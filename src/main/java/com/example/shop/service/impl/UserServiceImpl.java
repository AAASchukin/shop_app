package com.example.shop.service.impl;

import com.example.shop.entity.User;
import com.example.shop.repos.UserRepo;
import com.example.shop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;

    @Override
    public User add(User newUser) {
        userRepo.save(newUser);
        return newUser;
    }

    @Override
    public User getByLogin(String login) {
        return userRepo.findUserByLogin(login);
    }

    @Override
    public List<User> getByFirstNameAndLastName(String name, String surname) {
        return userRepo.findAllByFirstNameLikeIgnoreCaseAndLastNameLikeIgnoreCase(name, surname);
    }
}
