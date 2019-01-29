package com.example.demo.service;

import com.example.demo.domain.City;

public interface CityService {
    City findCityByName(String cityName);
}
