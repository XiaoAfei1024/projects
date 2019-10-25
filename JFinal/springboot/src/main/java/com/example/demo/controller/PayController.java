package com.example.demo.controller;

import com.example.demo.service.MyExecutor;
import com.example.demo.service.PayService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

/**
 * @Author Liao Feng
 * @Description //TODO
 * @Date 2019/10/15/015 10:51
 * @Version 1.0
 */
@Api(tags = "支付")
@RestController
@Slf4j
public class PayController {
    @Autowired
    private PayService service;

    @Autowired
    private MyExecutor executor;

    @PostMapping("/pay")
    public String payGood(String userName, String password) throws InterruptedException {
        service.getToken(userName, password);
        service.upLoadPic();
        double totalFee = service.dealOrder(userName);
        service.payMoney(totalFee);
        return "ok";
    }


    @GetMapping("/testAsync")
    public String testAsync() {
        for (int i = 0; i <10 ; i++) {
            executor.testAsync();
        }
        return"全部完成";
    }
    @GetMapping("/sleep")
    public String sleep() {
        //同步辅助类需要通过这个类来控制所有的线程都执行完成;
        CountDownLatch countDownLatch = new CountDownLatch(1000);
        for (int i = 0; i < 1000; i++) {
            executor.sleep(countDownLatch);
        }
        try {
            countDownLatch.await(); //保证之前的所有的线程都执行完成，才会走下面的；
            // 这样就可以在下面拿到所有线程执行完的集合结果
            return "全部完成";
        } catch (Exception e) {
            log.error("阻塞异常");
            return  "阻塞异常";
        }

    }
}
