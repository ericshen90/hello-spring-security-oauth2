package com.eric.spring.security.oauth2.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eric.spring.security.oauth2.server.dao.TbPermissionDao;
import com.eric.spring.security.oauth2.server.entity.TbPermission;
import com.eric.spring.security.oauth2.server.service.TbPermissionService;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限 服务实现类
 * </p>
 *
 * @author Eric Shen
 * @since 2019-12-11
 */
@Service
public class TbPermissionServiceImpl extends ServiceImpl<TbPermissionDao, TbPermission> implements TbPermissionService {

  @Override
  public List<TbPermission> getPermissionByUserId(Long userId) {
    return baseMapper.getPermissionByUserId(userId);
  }
}
