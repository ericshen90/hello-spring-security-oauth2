package com.eric.spring.oauth2.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author EricShen
 * @date 2019-12-10
 */
@Configuration
public class ClientConfiguration {
  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }
}
