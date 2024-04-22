package com.example.weatherapp.controller;

import org.springframework.format.annotation.DateTimeFormat;
import com.example.weatherapp.model.ForecastData;
import com.example.weatherapp.service.WeatherService;
import java.time.LocalDate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather")
    public String getWeatherForecast(@RequestParam String city, 
                                  @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, 
                                  Model model) {
    ForecastData forecastData = weatherService.getForecastForCity(city, date);
    model.addAttribute("forecastData", forecastData);
    return "forecast";
}
}
