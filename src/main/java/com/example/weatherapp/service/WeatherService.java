package com.example.weatherapp.service;

import com.example.weatherapp.model.ForecastData;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.time.LocalDate;
import java.time.Instant;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WeatherService {

    private final RestTemplate template;
    public WeatherService(RestTemplate restTemplate) {
        this.template = restTemplate;
    }

  public ForecastData getForecastForCity(String city, LocalDate date) {
    String url = "http://api.openweathermap.org/data/2.5/forecast?q=" + city + "&appid=574ce0a0f7a9f8eebe93a1fba46ddeb5&units=metric";
    ForecastData forecastData = template.getForObject(url, ForecastData.class);

    if (date != null && forecastData != null) {
        List<ForecastData.WeatherEntry> filteredList = forecastData.getList().stream()
            .filter(entry -> LocalDate.ofInstant(Instant.ofEpochSecond(entry.getDt()), ZoneId.systemDefault()).equals(date))
            .collect(Collectors.toList());
        forecastData.setList(filteredList);
    }

    return forecastData;
}
}
