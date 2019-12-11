package com.eric.spring.security.oauth2.server.service.impl;

import com.eric.spring.security.oauth2.server.entity.TbUserRole;
import com.eric.spring.security.oauth2.server.dao.TbUserRoleDao;
import com.eric.spring.security.oauth2.server.service.TbUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色 服务实现类
 * </p>
 *
 * @author Eric Shen
 * @since 2019-12-11
 */
@Service
public class TbUserRoleServiceImpl extends ServiceImpl<TbUserRoleDao, TbUserRole> implements TbUserRoleService {

}
