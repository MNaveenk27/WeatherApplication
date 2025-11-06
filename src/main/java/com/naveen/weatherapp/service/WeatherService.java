package com.naveen.weatherapp.service;

import com.naveen.weatherapp.dto.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service
public class WeatherService {
    public String test(){
        return "hello world";
    }
    @Value("${weather.api.key}")
    private String apiKey;
    @Value("${weather.api.url}")
    private String apiurl;
    @Value("${weather.api.forcast.url}")
    private String forcastUrl;
    private RestTemplate restTemplate = new RestTemplate();
    //the above class ##RestTemplate## helps to consume the other external apis
    public WeatherResponse getData(String city){
        String url=apiurl+"?key="+apiKey+"&q="+city;
        Root res = restTemplate.getForObject(url, Root.class);
        WeatherResponse weatherResponse = new WeatherResponse();
//        String n = res.getLocation().name;
//        String c=res.getLocation().country;
//        String r=res.getLocation().region;
//        weatherResponse.setCity(c);
//        weatherResponse.setCountry(c);
//        weatherResponse.setRegion(c);
        weatherResponse.setCity(res.getLocation().name);
        weatherResponse.setCountry(res.getLocation().country);
        weatherResponse.setRegion(res.getLocation().region);


        String condition=res.getCurrent().getCondition().getText();
        weatherResponse.setCondition(condition);
        weatherResponse.setTemp(res.getCurrent().getTemp_c());

        return weatherResponse;
    }
    public ForeCast getForecast(String city,int days){
        ForeCast fc=new ForeCast();
    WeatherResponse wc = getData(city);
    fc.setWeatherRes(wc);
List<DayTemp> dayList=new ArrayList<>();
        String url=forcastUrl+"?key="+apiKey+"&q="+city+"&days="+days;
        Root apiResponse = restTemplate.getForObject(url, Root.class);
        WeatherResponse weatherResponse = new WeatherResponse();
        ForeCast forcast = apiResponse.getForecast();
        List<Forecastday> fcd = forcast.getForecastday();
        for(Forecastday forecastday : fcd){
                DayTemp d = new DayTemp();
                d.setDate(forecastday.getDate());
                d.setMinTemp(forecastday.getDay().mintemp_c);
                d.setMaxTemp(forecastday.getDay().maxtemp_c);
                d.setAvgTemp(forecastday.getDay().avgtemp_c);
                dayList.add(d);
        }
        forcast.setDayTemp(dayList);

    return forcast;

    }
}
