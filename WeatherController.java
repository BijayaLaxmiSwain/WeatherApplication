package com.example.controller;

import org.springframework.web.bind.annotation.*;

import com.example.model.WeatherResponse;
import com.example.service.WeatherService;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherService service;

    public WeatherController(WeatherService service) {
        this.service = service;
    }

    @GetMapping("/{city}")
    public WeatherResponse getWeather(@PathVariable String city) {
        return service.getCurrentWeather(city);
    }
}
