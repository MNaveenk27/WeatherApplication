package com.naveen.weatherapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Forecastday{
    public String date;
    public int date_epoch;
    public Day day;
    public Astro astro;
    public ArrayList<Hour> hour;
}