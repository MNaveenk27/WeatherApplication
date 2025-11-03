package com.naveen.weatherapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Root{
    public Location location;
    public Current current;
    public Root() {};
}