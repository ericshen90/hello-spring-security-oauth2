package com.eric.spring.security.oauth2.server.config.service;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.eric.spring.security.oauth2.server.entity.TbPermission;
import com.eric.spring.security.oauth2.server.entity.TbUser;
import com.eric.spring.security.oauth2.server.service.TbPermissionService;
import com.eric.spring.security.oauth2.server.service.TbUserService;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Resource;
import org.assertj.core.util.Lists;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author EricShen
 * @date 2019-12-11
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Resource
  private TbUserService tbUserService;

  @Resource
  private TbPermissionService tbPermissionService;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    TbUser tbUser = tbUserService.getByUsername(username);
    if (tbUser != null) {
      List<GrantedAuthority> grantedAuthorities = Lists.newArrayList();
      // 声明用户授权
      List<TbPermission> permissions = tbPermissionService.getPermissionByUserId(tbUser.getId());
      permissions.forEach(permission -> {
        if (permission != null && StringUtils.isNotBlank(permission.getEnname())) {
          GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getEnname());
          grantedAuthorities.add(grantedAuthority);
        }
      });
      // Spring Security框架完成认证
      return new User(username, tbUser.getPassword(), grantedAuthorities);
    }
    return null;
  }
}
