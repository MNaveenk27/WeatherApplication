package com.naveen.weatherapp.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Bean;

import java.util.List;

@Setter
@Getter
public class WeatherForeCast {

    private WeatherResponse weatherResponse;
    private List<DayTemp> dayTemp;


}