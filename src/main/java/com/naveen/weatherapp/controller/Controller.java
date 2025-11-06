package com.naveen.weatherapp.controller;

import com.naveen.weatherapp.dto.Root;
import com.naveen.weatherapp.dto.WeatherResponse;
import com.naveen.weatherapp.dto.ForeCast;
import com.naveen.weatherapp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public WeatherResponse getWeather(@PathVariable String city) {
        return weatherService.getData(city);
    }

    @GetMapping("/forcast")
    public ForeCast getForecast(@RequestParam String city, @RequestParam int days) {
        return weatherService.getForecast(city,days);
    }

}
