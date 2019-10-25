package com.example.demo.controller;

import com.example.demo.domain.City;
import com.example.demo.service.CityService;
import com.example.demo.service.MyExecutor;
import io.swagger.annotations.Api;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "城市相关")
@RestController
public class CityRestController {
    @Autowired
    private CityService cityService;

    @Autowired
    private MyExecutor executor;

    @RequestMapping(value = "/city", method = RequestMethod.GET)
    public City findOneCity(@RequestParam(value = "id", required = true) int id) {
        return cityService.findCityById(id);
    }

    @RequestMapping("/city/findAll")
    public List<City> findAll() {
        return cityService.findAll();
    }

    @RequestMapping("/city/insert")
    public void insert(City city) {
        cityService.insert(city);
    }

    @RequestMapping("/city/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        cityService.delete(id);
    }

    @GetMapping("/sleep")
    public void sleep() {
        for (int i = 0; i < 1000; i++) {
            executor.sleep();
        }
    }
}
