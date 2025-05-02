package com.practice.weather_api.logger;

//import jakarta.annotation.PostConstruct;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.context.event.ApplicationReadyEvent;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.event.EventListener;
//import org.springframework.core.env.Environment;
//import org.springframework.stereotype.Component;
//
//@Component
//@Slf4j
//@Configuration
//public class RedisStartupLogger {
//
//  @Value("${spring.redis.host}")
//  private String redisHost;
//
//  @Value("${spring.redis.port}")
//  private int redisPort;
//
//  @Autowired
//  private Environment env;
//
//  @EventListener(ApplicationReadyEvent.class)
//  public void logRedisConfig() {
//    System.out.println("🚀 from properties: Redis Host: " + redisHost);
//    System.out.println("🚀 from properties: Redis Port: " + redisPort);
//  }
//
//  @PostConstruct
//  public void logRedisProperties() {
//    log.info("🎯 Environment: spring.redis.host -> {}", env.getProperty("spring.redis.host"));
//    log.info("🎯 Environment: spring.redis.port -> {}", env.getProperty("spring.redis.port"));
//  }
//}
