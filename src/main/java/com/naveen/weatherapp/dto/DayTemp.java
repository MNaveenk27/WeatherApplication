package com.naveen.weatherapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DayTemp {
    private String date;
    private double minTemp;
    private double maxTemp;
    private double avgTemp;
    private String condition; // Add this field

}
