package com.eric.spring.security.oauth2.resource.service.impl;

import com.eric.spring.security.oauth2.resource.entity.TbContent;
import com.eric.spring.security.oauth2.resource.dao.TbContentDao;
import com.eric.spring.security.oauth2.resource.service.TbContentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Eric Shen
 * @since 2019-12-13
 */
@Service
public class TbContentServiceImpl extends ServiceImpl<TbContentDao, TbContent> implements
    TbContentService {

}
