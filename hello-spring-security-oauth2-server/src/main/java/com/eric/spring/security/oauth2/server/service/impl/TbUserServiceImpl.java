package com.eric.spring.security.oauth2.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eric.spring.security.oauth2.server.dao.TbUserDao;
import com.eric.spring.security.oauth2.server.entity.TbUser;
import com.eric.spring.security.oauth2.server.service.TbUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author Eric Shen
 * @since 2019-12-11
 */
@Service
public class TbUserServiceImpl extends ServiceImpl<TbUserDao, TbUser> implements TbUserService {

  @Override
  public TbUser getByUsername(String username) {
    return getOne(new QueryWrapper<TbUser>().eq(TbUser.USERNAME, username));
  }
}
