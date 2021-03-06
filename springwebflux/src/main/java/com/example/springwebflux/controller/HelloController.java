package com.example.springwebflux.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public Mono<String> hello() {// 【改】返回类型为Mono<String>
        return Mono.just("welcome to reactive world ~");// 【改】使用Mono.just生成响应式数据
    }
}
