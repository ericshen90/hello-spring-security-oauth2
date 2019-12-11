package com.eric.spring.security.oauth2.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 *
 * @author EricShen
 * @date 2019-12-09
 */
@SpringBootApplication
@MapperScan("com.eric.spring.security.oauth2.server.dao")
public class OAuth2ServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(OAuth2ServerApplication.class, args);
  }
}
