package com.example.demo.dao;

import com.example.demo.domain.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import org.springframework.stereotype.Repository;


import java.util.List;

@Repository    //用来注解接口
@Mapper
public interface CityDao {
    /**
     * 根据城市名称，查询城市信息
     *
     * @param id 城市名
     */
    City findById(@Param("id") int id);
    List<City> findAll();
    void insert(City city);
    void update(Long id);
    void delete(Long id);
}
