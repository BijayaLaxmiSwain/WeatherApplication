package com.example.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.model.WeatherResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;

    @Value("${weather.api.url}")
    private String apiUrl;

    public WeatherResponse getCurrentWeather(String city) {

        String url = apiUrl + "/weather?q=" + city + "&appid=" + apiKey + "&units=metric";

        RestTemplate restTemplate = new RestTemplate();
        WeatherResponse response = new WeatherResponse();

        try {
            String json = restTemplate.getForObject(url, String.class);

            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(json);

            response.setTemperature(root.path("main").path("temp").asDouble());
            response.setHumidity(root.path("main").path("humidity").asInt());

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Weather API call failed");
        }

        return response;
    }
}
