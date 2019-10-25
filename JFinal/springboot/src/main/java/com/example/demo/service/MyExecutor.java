package com.example.demo.service;

import java.util.concurrent.CountDownLatch;

public interface MyExecutor {
    void sleep(CountDownLatch countDownLatch);

    void testAsync();
}
