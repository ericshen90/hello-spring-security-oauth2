package com.eric.spring.security.oauth2.server.service.impl;

import com.eric.spring.security.oauth2.server.entity.TbRolePermission;
import com.eric.spring.security.oauth2.server.dao.TbRolePermissionDao;
import com.eric.spring.security.oauth2.server.service.TbRolePermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色权限 服务实现类
 * </p>
 *
 * @author Eric Shen
 * @since 2019-12-11
 */
@Service
public class TbRolePermissionServiceImpl extends ServiceImpl<TbRolePermissionDao, TbRolePermission> implements TbRolePermissionService {

}
