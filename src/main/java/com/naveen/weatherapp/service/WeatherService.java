package com.naveen.weatherapp.service;

import com.naveen.weatherapp.dto.Root;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class WeatherService {
    public String test(){
        return "hello world";
    }
    @Value("${weather.api.key}")
    private String apiKey;
    @Value("${weather.api.url}")
    private String apiurl;
    private RestTemplate restTemplate = new RestTemplate();
    //the above class ##RestTemplate## helps to consume the other external apis
    public Root getData(String city){
        String url=apiurl+"?key="+apiKey+"&q="+city;
        Root res = restTemplate.getForObject(url, Root.class);
        return res;
    }
}
