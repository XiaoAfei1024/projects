package com.example.springshiro.repository;

import com.example.springshiro.domain.User;

public interface UserRepository extends BaseRepository<User,Long>{
    User findByName(String name);
}
