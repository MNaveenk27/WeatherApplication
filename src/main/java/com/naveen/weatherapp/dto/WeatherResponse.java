package com.naveen.weatherapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WeatherResponse {
    private String city;
    private String condition;
    private Double temp;

}

