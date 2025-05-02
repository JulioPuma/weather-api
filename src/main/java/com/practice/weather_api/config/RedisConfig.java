package com.practice.weather_api.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.lettuce.core.ClientOptions;
import org.springframework.boot.autoconfigure.data.redis.LettuceClientConfigurationBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;

@Configuration
public class RedisConfig {
  
  @Bean
  public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory, ObjectMapper objectMapper) {
    
    Jackson2JsonRedisSerializer<Object> serializer = new Jackson2JsonRedisSerializer<>(Object.class);
    serializer.setObjectMapper(objectMapper);
    
    RedisSerializationContext.SerializationPair<Object> pair =
      RedisSerializationContext.SerializationPair.fromSerializer(serializer);
    
    RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
      .serializeValuesWith(pair);
    
    return RedisCacheManager.builder(connectionFactory)
      .cacheDefaults(config)
      .build();
  }
  
//  @Bean
//  public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory, ObjectMapper objectMapper) {
//
//    GenericJackson2JsonRedisSerializer genericSerializer = new GenericJackson2JsonRedisSerializer(objectMapper);
//
//    RedisSerializationContext.SerializationPair<Object> pair =
//      RedisSerializationContext.SerializationPair.fromSerializer(genericSerializer);
//
//    RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
//      .serializeValuesWith(pair);
//
//    return RedisCacheManager.builder(connectionFactory)
//      .cacheDefaults(config)
//      .build();
//  }
  
  @Bean
  public LettuceClientConfigurationBuilderCustomizer lettuceClientCustomizer() {
    return builder -> builder.commandTimeout(Duration.ofSeconds(5))
      .shutdownTimeout(Duration.ofMillis(100))
      .clientOptions(ClientOptions.builder()
        .autoReconnect(true)
        .build());
  }
}