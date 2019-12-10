package com.eric.spring.security.oauth2.server.config;

import javax.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * 认证服务器
 *
 * @author EricShen
 * @date 2019-12-10
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

  @Resource
  private BCryptPasswordEncoder passwordEncoder;

  @Override
  public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
    // 配置客户端
    clients
        // 使用内存设置
        .inMemory()
        // 客户端id
        .withClient("client")
        // 客户端密码
        .secret(passwordEncoder.encode("secret"))
        // 授权类型
        .authorizedGrantTypes("authorization_code")
        // 授权范围
        .scopes("app")
        // 注册回调地址
        .redirectUris("https://www.google.com");
  }
}
