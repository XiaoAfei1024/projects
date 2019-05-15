package com.example.demo.service.impl;

import com.example.demo.dao.CityDao;
import com.example.demo.domain.City;
import com.example.demo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityDao cityDao;
    @Override
    public City findCityById(int id) {
        return cityDao.findById(id);
    }

    @Override
    public List<City> findAll() {
        return cityDao.findAll();
    }

    @Override
    public void insert(City city) {
        cityDao.insert(city);
    }

    @Override
    public void update(Long id) {
        cityDao.update(id);
    }

    @Override
    public void delete(Long id) {
        cityDao.delete(id);
    }
}
