package com.example.demo.controller;

import com.example.demo.dao.UserDao;
import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "user 相关")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUsers")
    public PageInfo<User> getUser(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        PageHelper.startPage(pageNum,5);//  用来设置页面的位置和展示的数据条目数
        List<User> users = userService.findByUserAll();
        PageInfo<User> userPageInfo = new PageInfo<>(users);

        return userPageInfo;
    }

    @RequestMapping(value = "/getUser/{id}")
    public User getOneUser(@PathVariable("id") Long id) {
        return userService.findByUserOne(id);
    }

    @RequestMapping("/add")
    public void save(User user) {
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

    @RequestMapping(value = "/insert")
    public void insert(User user) {
        userService.insertUser(user);
    }
}
