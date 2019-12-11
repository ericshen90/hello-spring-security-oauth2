package com.eric.spring.security.oauth2.server.service;

import com.eric.spring.security.oauth2.server.entity.TbPermission;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * <p>
 * 权限 服务类
 * </p>
 *
 * @author Eric Shen
 * @since 2019-12-11
 */
public interface TbPermissionService extends IService<TbPermission> {
  /**
   * 通过userId获取权限列
   * @param userId
   * @return
   */
  List<TbPermission> getPermissionByUserId(Long userId);
}
