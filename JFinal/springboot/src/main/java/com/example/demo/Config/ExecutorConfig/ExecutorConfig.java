package com.example.demo.Config.ExecutorConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
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
@EnableAsync
public class ExecutorConfig {
    @Bean("myExecutor")
    public Executor asyncPromiseExecutor() {
        ThreadPoolTaskExecutor executor = new VisiableThreadPoolTaskExecutor();
        // 核心线程数：当线程数小于核心线程数，线程池创建线程
        // 核心线程：一直存活，即使没有任务
        executor.setCorePoolSize(50);
        //线程池最大线程数
        //(如果线程数已等于maxPoolSize，且任务队列已满，则已超出线程池的处理能力，线程池会拒绝处理任务而抛出异常。)
        executor.setMaxPoolSize(100);
        //线程空闲时间
        //当线程空闲时间达到keepAliveTime，该线程会退出，直到线程数量等于corePoolSize
        executor.setKeepAliveSeconds(0);
        //任务阻塞队列容量
        executor.setQueueCapacity(150);
        //配置线程池中的线程的名称前缀
        executor.setThreadNamePrefix("my-thread-");

        // 线程池阻塞队列满之后的任务处理策略，有AbortPolicy，DiscardPolicy，DiscardOldestPolicy，CallerRunsPolicy，自定义
        // AbortPolicy，默认策略，队列满丢掉任务并抛出异常
        // DiscardPolicy，队列满丢掉任务，不抛出异常
        // DiscardOldestPolicy，队列满丢掉最老的任务，不抛出任务
        // CallerRunsPolicy，队列满，由调用线程来跑（这么干一般是主线程...）
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //执行初始化
        executor.initialize();
        return executor;
    }
}
