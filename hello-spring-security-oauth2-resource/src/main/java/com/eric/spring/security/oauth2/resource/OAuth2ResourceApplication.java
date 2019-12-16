package com.eric.spring.security.oauth2.resource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author EricShen
 * @date 2019-12-13
 */
@SpringBootApplication
@MapperScan("com.eric.spring.security.oauth2.resource.dao")
public class OAuth2ResourceApplication {

  public static void main(String[] args) {
    SpringApplication.run(OAuth2ResourceApplication.class, args);
  }

}
