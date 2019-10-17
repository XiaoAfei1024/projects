package com.example.demo.hadnler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Liao Feng
 * @Description //TODO
 * @Date 2019/10/15/015 11:37
 * @Version 1.0
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public Map<String,Object> exceptionHandler(Exception ex){
        Map<String,Object> map  = new HashMap<String,Object>();
        map.put("code",100);
        map.put("msg",ex.getMessage());
        //这里可以加上我们其他的异常处理代码，比如日志记录，，，
        return map;
    }
}
