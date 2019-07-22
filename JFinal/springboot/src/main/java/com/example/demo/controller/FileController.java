package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;

/**
 * @Author Liao Feng
 * @Description //TODO
 * @Date 2019/6/21/021 11:11
 * @Version 1.0
 */
@Controller
@RequestMapping("/file")
public class FileController {
    @RequestMapping(value = "/loadData",method = RequestMethod.GET)
    @ResponseBody
    public String[] loadData() {
        File path = new File("src/");
        String[] list = path.list();
        return list;
    }
}

