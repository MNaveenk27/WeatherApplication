package com.naveen.weatherapp.service;

import com.naveen.weatherapp.dto.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

//
//@Service
//public class WeatherService {
//    public String test(){
//        return "hello world";
//    }
//    @Value("${weather.api.key}")
//    private String apiKey;
//    @Value("${weather.api.url}")
//    private String apiurl;
//    @Value("${weather.api.forcast.url}")
//    private String forcastUrl;
//    private RestTemplate restTemplate = new RestTemplate();
//    //the above class ##RestTemplate## helps to consume the other external apis
//    public WeatherResponse getData(String city){
//        String url=apiurl+"?key="+apiKey+"&q="+city;
//        Root res = restTemplate.getForObject(url, Root.class);
////        acting as a client to consume web services easily with methods like
////        getForObject() for fetching data and postForObject() for sending it
//        WeatherResponse weatherResponse = new WeatherResponse();
////        String n = res.getLocation().name;
////        String c=res.getLocation().country;
////        String r=res.getLocation().region;
////        weatherResponse.setCity(c);
////        weatherResponse.setCountry(c);
////        weatherResponse.setRegion(c);
//        weatherResponse.setCity(res.getLocation().getName());
//        weatherResponse.setCountry(res.getLocation().getCountry());
//        weatherResponse.setRegion(res.getLocation().getRegion());
//
//
//        String condition=res.getCurrent().getCondition().getText();
////        res.getCurrent().getCondition().getText()
//        weatherResponse.setCondition(condition);
//        weatherResponse.setTemp(res.getCurrent().getTemp_c());
//
//        return weatherResponse;
//    }
//    public ForeCast getForecast(String city,int days){
////        ForeCast fc=new ForeCast();
//    WeatherResponse wc = getData(city);
//    List<DayTemp> dayList=new ArrayList<>();
//        String url=forcastUrl+"?key="+apiKey+"&q="+city+"&days="+days;
//        Root apiResponse = restTemplate.getForObject(url, Root.class);
//        WeatherResponse weatherResponse = new WeatherResponse();
//        ForeCast fc = apiResponse.getForecast();
//        List<Forecastday> fcd = fc.getForecastday();
//    fc.setWeatherRes(wc);
//        for(Forecastday forecastday : fcd){
//                DayTemp d = new DayTemp();
//                d.setDate(forecastday.getDate());
//                d.setMinTemp(forecastday.getDay().mintemp_c);
//                d.setMaxTemp(forecastday.getDay().maxtemp_c);
//                d.setAvgTemp(forecastday.getDay().avgtemp_c);
//                dayList.add(d);
//        }
//        fc.setDayTemp(dayList);
//
//    return fc;
//
//    }
//}
import com.naveen.weatherapp.dto.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;

    @Value("${weather.api.url}")
    private String apiUrl;

    @Value("${weather.api.forecast.url}")
    private String apiForecastUrl;

    private RestTemplate template=new RestTemplate();
    public String test()
    {
        return "good";
    }

    public WeatherResponse getData(String city)
    {
        String url = apiUrl +"?key="+apiKey+"&q="+city;
        Root response = template.getForObject(url, Root.class);
        WeatherResponse weatherResponse=new WeatherResponse();

        weatherResponse.setCity(response.getLocation().name);
        weatherResponse.setRegion(response.getLocation().region);
        weatherResponse.setCountry(response.getLocation().country);
        String condition = response.getCurrent().getCondition().getText();
        weatherResponse.setCondition(condition);
        weatherResponse.setTemp(response.getCurrent().getTemp_c());
        return weatherResponse;
    }

    public WeatherForeCast getForeCast(String city, int days)
    {
        WeatherForeCast weatherForeCast=new WeatherForeCast();
        WeatherResponse weatherResponse = getData(city);
        WeatherForeCast response = new WeatherForeCast();
        response.setWeatherResponse(weatherResponse);

        List<DayTemp> dayList = new ArrayList<>();
        String url = apiForecastUrl +"?key="+apiKey+"&q="+city+"&days="+days;
        Root apiResponse = template.getForObject(url, Root.class);
        ForeCast forecast = apiResponse.getForecast();
        List<Forecastday> forecastday = forecast.getForecastday();
        for(Forecastday rs: forecastday)
        {
            DayTemp d=new DayTemp();
            d.setDate(rs.getDate());
            d.setMinTemp(rs.getDay().mintemp_c);
            d.setAvgTemp(rs.getDay().avgtemp_c);
            d.setMaxTemp(rs.getDay().maxtemp_c);
            d.setCondition(rs.getDay().getCondition().getText());
            dayList.add(d);
        }

        response.setDayTemp(dayList);
        return response;

    }
}