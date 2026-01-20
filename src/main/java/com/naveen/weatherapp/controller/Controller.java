package com.naveen.weatherapp.controller;

import com.naveen.weatherapp.dto.Root;
import com.naveen.weatherapp.dto.WeatherForeCast;
import com.naveen.weatherapp.dto.WeatherResponse;
import com.naveen.weatherapp.dto.ForeCast;
import com.naveen.weatherapp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//ce35bee56e83417b947181443250311
@RestController
@RequestMapping("/weather")
public class Controller {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/my/{city}")
    public ResponseEntity<WeatherResponse> getWeather(@PathVariable String city) {
        try {
            return ResponseEntity.ok(weatherService.getData(city));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/forecast")
    public ResponseEntity<WeatherForeCast> getForecast(@RequestParam String city, @RequestParam int days) {
        try {
            return ResponseEntity.ok(weatherService.getForeCast(city, days));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}