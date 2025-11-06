package com.naveen.weatherapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Root{
    public Location location;
    public Current current;
    private ForeCast forecast;

}