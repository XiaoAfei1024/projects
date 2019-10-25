package com.example.demo.service.impl;

import com.example.demo.service.MyExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.CountDownLatch;

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
    @Async("myExecutor")
    public void testAsync() {
        try {
            log.info("线程" + Thread.currentThread().getId() + "开始运行");
            Thread.sleep(2000);
            log.info("线程" + Thread.currentThread().getId() + "结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sleep(CountDownLatch countDownLatch) {
        executor.execute(() ->{
                    try {
                        startSleep();
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        countDownLatch.countDown();  //这个不管是否异常都需要数量减,否则会被堵塞无法结束
                        log.info(countDownLatch.toString());
                    }
                }
        );
    }
    private void startSleep() throws Exception {
            log.info("线程" + Thread.currentThread().getId() + "开始运行");
            Thread.sleep(1000);
            log.info("线程" + Thread.currentThread().getId() + "结束");

    }

}
