package com.eric.spring.security.oauth2.resource.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * 资源服务器配置
 *
 * Session 创建策略 ↓
 * @see SessionCreationPolicy
 *
 * @author EricShen
 * @date 2019-12-13
 */
@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

  @Override
  public void configure(HttpSecurity http) throws Exception {
    http
        .exceptionHandling()
        .and()
        .sessionManagement()
        // Session 创建策略
        // ALWAYS 总是创建 HttpSession
        // IF_REQUIRED Spring Security 只会在需要时创建一个 HttpSession
        // NEVER Spring Security 不会创建 HttpSession，但如果它已经存在，将可以使用 HttpSession
        // STATELESS Spring Security 永远不会创建 HttpSession，它不会使用 HttpSession 来获取 SecurityContext
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .authorizeRequests()
        .antMatchers("/").hasAuthority("System")
        .antMatchers("/view/**").hasAuthority("SystemContentView")
        .antMatchers("/insert/**").hasAuthority("SystemContentInsert")
        .antMatchers("/update/**").hasAuthority("SystemContentUpdate")
        .antMatchers("/delete/**").hasAuthority("SystemContentDelete");
  }
}
