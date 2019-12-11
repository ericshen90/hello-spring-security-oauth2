package com.eric.spring.security.oauth2.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eric.spring.security.oauth2.server.dao.TbRoleDao;
import com.eric.spring.security.oauth2.server.entity.TbRole;
import com.eric.spring.security.oauth2.server.service.TbRoleService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @author Eric Shen
 * @since 2019-12-11
 */
@Service
public class TbRoleServiceImpl extends ServiceImpl<TbRoleDao, TbRole> implements TbRoleService {

}
