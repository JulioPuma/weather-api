package com.practice.weather_api.config;

import com.practice.weather_api.autogenerate.api.TimelineWeatherApi15DayForecastRequestApi;
import com.practice.weather_api.autogenerate.api.WeatherForecastApi;
import com.practice.weather_api.autogenerate.invoker.ApiClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiClientConfig {
  
  @Value("${weather.api.base-url}")
  private String baseUrl;
  
  @Value("${weather.api.key}")
  private String apiKey;
  
  @Bean
  public ApiClient apiClient() {
    ApiClient client = new ApiClient();
    client.setBasePath(baseUrl);
    client.setApiKey(apiKey);
    return client;
  }
  
  @Bean
  public TimelineWeatherApi15DayForecastRequestApi weatherForecastApi(ApiClient client) {
    return new TimelineWeatherApi15DayForecastRequestApi(client);
  }
}