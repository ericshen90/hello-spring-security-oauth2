package com.eric.spring.security.oauth2.server.service;

import com.eric.spring.security.oauth2.server.entity.TbUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author Eric Shen
 * @since 2019-12-11
 */
public interface TbUserService extends IService<TbUser> {

  /**
   * username查询用户
   * @param username
   * @return
   */
  TbUser getByUsername(String username);

}
