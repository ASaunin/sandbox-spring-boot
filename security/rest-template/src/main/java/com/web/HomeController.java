package com.web;

import com.model.Weather;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HomeController {

    @RequestMapping("/")
    public Weather home(){
        final RestTemplate restTemplate = new RestTemplate();
        final Weather weather = restTemplate.getForObject("http://localhost:8080/data/weather.json", Weather.class);
        return weather;
    }

}