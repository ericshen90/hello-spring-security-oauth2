package com.eric.spring.security.oauth2.server.config;

import javax.annotation.Resource;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

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
  private DataSource dataSource;
  @Resource
  private AuthenticationManager authenticationManager;
  @Resource
  private UserDetailsService userDetailsService;


  @Bean
  public TokenStore tokenStore() {
    // 基于JDBC实现，令牌保存到数据库
    return new JdbcTokenStore(dataSource);
  }

  @Bean
  public ClientDetailsService jdbcClientDetailsService() {
    // 基于JDBC实现，需要事先在数据库配置客户端信息
    return new JdbcClientDetailsService(dataSource);
  }

  @Override
  public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
    // 设置令牌存储模式
    endpoints
        .tokenStore(tokenStore())
        .authenticationManager(authenticationManager)
        .userDetailsService(userDetailsService);
  }

  @Override
  public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
    // 配置客户端
    clients.withClientDetails(jdbcClientDetailsService());
  }
}
