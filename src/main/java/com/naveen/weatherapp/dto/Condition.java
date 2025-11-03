package com.naveen.weatherapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Condition {
    public String text;
    public String icon;
    public int code;
    public Condition(){};
}
