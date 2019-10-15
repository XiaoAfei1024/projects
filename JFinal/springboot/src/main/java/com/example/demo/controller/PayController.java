package com.example.demo.controller;

import com.example.demo.service.PayService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;

/**
 * @Author Liao Feng
 * @Description //TODO
 * @Date 2019/10/15/015 10:51
 * @Version 1.0
 */
@Api(tags = "支付")
@RestController
public class PayController {
    @Autowired
    private PayService service;

    @PostMapping("/pay")
    public String payGood(String userName, String password) throws InterruptedException {
        service.getToken(userName, password);
        service.upLoadPic();
        double totalFee = service.dealOrder(userName);
        service.payMoney(totalFee);
        return "ok";
    }
}
