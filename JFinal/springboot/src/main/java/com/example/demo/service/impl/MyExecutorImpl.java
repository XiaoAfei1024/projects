package com.example.demo.service.impl;

import com.example.demo.service.MyExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author Liao Feng
 * @Description //TODO
 * @Date 2019/10/25/025 10:44
 * @Version 1.0
 */
@Service
@Slf4j
public class MyExecutorImpl implements MyExecutor {
    @Resource(name = "myExecutor")
    private ThreadPoolTaskExecutor executor;

    @Override
    public void sleep() {
        executor.execute(() -> startSleep());
    }
    private void startSleep() {
        try {
            log.info("线程" + Thread.currentThread().getId() + "开始运行");
            Thread.sleep(1000);
            log.info("线程" + Thread.currentThread().getId() + "结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
