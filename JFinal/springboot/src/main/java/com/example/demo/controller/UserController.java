package com.example.demo.controller;

import com.example.demo.dao.UserDao;
import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/getUsers")
    public List<User> getUser() {
        List<User> users = userService.findByUserAll();
        return users;
    }

    @RequestMapping("/add")
    public void save(User user){
        userService.insertUser(user);
    }

    @RequestMapping(value = "update")
    public void update(User user) {
        userService.updateUser(user);
    }
    @RequestMapping(value = "/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }

}
