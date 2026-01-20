package com.naveen.weatherapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ForeCast {
    private WeatherResponse weatherRes;
    public List<DayTemp> dayTemp;
    @JsonProperty("forecastday")
    private List<Forecastday> forecastday;



}
