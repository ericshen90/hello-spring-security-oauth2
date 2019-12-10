package com.eric.spring.security.oauth2.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 *
 * @author EricShen
 * @date 2019-12-09
 */
@SpringBootApplication
public class OAuth2ServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(OAuth2ServerApplication.class, args);
  }
}
