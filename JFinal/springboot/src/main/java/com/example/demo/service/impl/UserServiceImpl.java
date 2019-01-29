package com.example.demo.service.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public List<User> findByUserAll() {
        return userDao.getAll();
    }

    @Override
    public User findByUserOne(Long id) {
        return userDao.getOne(id);
    }

    @Override
    public void insertUser(User user) {
        userDao.insert(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.insert(user);
    }

    @Override
    public void deleteUser(Long id) {

    }
}
