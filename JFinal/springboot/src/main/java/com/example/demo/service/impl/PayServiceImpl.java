package com.example.demo.service.impl;

import com.example.demo.service.PayService;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author Liao Feng
 * @Description //TODO
 * @Date 2019/10/15/015 10:54
 * @Version 1.0
 */
@Service
public class PayServiceImpl implements PayService {
    @Override
    public String upLoadPic() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        return "url";    }

    @Override
    public void payMoney(double totalFee) throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
    }

    @Override
    public double dealOrder(String userName) throws InterruptedException {
        double sum = 0;
        for (int i = 0; i < 20; i++) {
            TimeUnit.MILLISECONDS.sleep(100);// 模拟处理单个订单消耗00毫秒，20个订单为2秒
            sum += i * 50.00;
        }
        return sum;
    }

    @Override
    public String getToken(String userName, String password) throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);// 模拟调用时间为2秒
        return "123456";
    }
}
