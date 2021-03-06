package com.example.demo.service;

import com.example.demo.domain.City;

import java.util.List;

public interface CityService {
    City findCityById(int id);
    List<City> findAll();
    void insert(City city);
    void update(Long id);
    void delete(Long id);
}
