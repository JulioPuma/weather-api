package com.practice.weather_api.service;

import com.practice.weather_api.autogenerate.api.TimelineWeatherApi15DayForecastRequestApi;
import com.practice.weather_api.autogenerate.model.WeatherForecastResponse;
import com.practice.weather_api.config.ApplicationProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class WeatherService {
  
  private final TimelineWeatherApi15DayForecastRequestApi timelineWeatherApi15DayForecastRequestApi;
  
  @Cacheable(value = "weather", key = "#city")
  public Mono<WeatherForecastResponse> getForecastByCity(String city) {
    return timelineWeatherApi15DayForecastRequestApi.visualCrossingWebServicesRestServicesTimelineLocationGet(
      city,
      "json",
      "metric",
      "current",
      "es");
  }
}