package com.example.demo.service;

import com.example.demo.domain.User;

import java.util.List;

public interface UserService {
    List<User> findByUserAll();

    User findByUserOne(Long id);

    void insertUser(User user);

    void updateUser(User user);

    void deleteUser(Long id);
}
