package com.example.springwebflux.dao;

import com.example.springwebflux.model.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;


public interface UserRepository extends ReactiveCrudRepository<User,String> { // ReactiveCrudRepository的泛型分别是User和ID的类型
    Mono<User> findByUsername(String username); // ReactiveCrudRepository已经提供了基本的增删改查的方法，根据业务需要，我们增加四个方法
    Mono<Long> deleteByUsername(String username);
}
