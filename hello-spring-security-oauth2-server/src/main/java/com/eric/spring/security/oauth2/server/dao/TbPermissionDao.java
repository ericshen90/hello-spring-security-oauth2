package com.eric.spring.security.oauth2.server.dao;

import com.eric.spring.security.oauth2.server.entity.TbPermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;

/**
 * <p>
 * 权限 Mapper 接口
 * </p>
 *
 * @author Eric Shen
 * @since 2019-12-11
 */
public interface TbPermissionDao extends BaseMapper<TbPermission> {

  /**
   * 通过userId获取权限列
   * @param userId
   * @return
   */
  List<TbPermission> getPermissionByUserId(Long userId);
}
