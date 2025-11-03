package com.naveen.weatherapp.controller;

import com.naveen.weatherapp.dto.Root;
import com.naveen.weatherapp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//ce35bee56e83417b947181443250311
@RestController
@RequestMapping("/weather")
public class Controller {
    @Autowired
    private WeatherService weatherService;
//    @GetMapping("/{city}")
//    public WeatherService getWeather(@PathVariable String city) {
//        return weatherService.test();
//    }
    @GetMapping("my/{city}")
    public Root getWeather(@PathVariable String city) {
        return weatherService.getData(city);
    }

}
