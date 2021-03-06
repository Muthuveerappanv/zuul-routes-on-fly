package com.example.demo;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ConditionalOnProperty(name = "spring.cloud.bus.enabled", havingValue = "true", matchIfMissing = false)
public class AppConfig {

  @Primary
  @Bean(name = "zuulConfigProperties")
  @RefreshScope
  @ConfigurationProperties("zuul")
  public ZuulProperties zuulProperties() {
    return new ZuulProperties();
  }
}