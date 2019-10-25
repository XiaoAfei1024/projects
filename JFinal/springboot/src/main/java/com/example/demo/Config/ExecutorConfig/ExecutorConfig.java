package com.example.demo.Config.ExecutorConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author Liao Feng
 * @Description //TODO
 * @Date 2019/10/18/018 12:11
 * @Version 1.0
 */
@Configuration
public class ExecutorConfig {
    @Bean("myExecutor")
    public Executor asyncPromiseExecutor() {
        ThreadPoolTaskExecutor executor = new VisiableThreadPoolTaskExecutor();
        //核心线程数
        executor.setCorePoolSize(50);
        //线程池最大线程数
        //(如果线程数已等于maxPoolSize，且任务队列已满，则已超出线程池的处理能力，线程池会拒绝处理任务而抛出异常。)
        executor.setMaxPoolSize(100);
        //线程空闲时间
        //当线程空闲时间达到keepAliveTime，该线程会退出，直到线程数量等于corePoolSize
        executor.setKeepAliveSeconds(0);
        //任务队列容量
        executor.setQueueCapacity(150);
        //配置线程池中的线程的名称前缀
        executor.setThreadNamePrefix("my-thread-");
        //不在新线程中执行任务，而是有调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //执行初始化
        executor.initialize();
        return executor;
    }
}
