package com.practice.weather_api.controller;

import com.practice.weather_api.autogenerate.model.WeatherForecastResponse;
import com.practice.weather_api.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/weather")
@RequiredArgsConstructor
public class WeatherController {
  
  private final WeatherService weatherService;
  
  @GetMapping("/{city}")
  public Mono<WeatherForecastResponse> getForecast(@PathVariable String city) {
    return weatherService.getForecastByCity(city);
  }
}