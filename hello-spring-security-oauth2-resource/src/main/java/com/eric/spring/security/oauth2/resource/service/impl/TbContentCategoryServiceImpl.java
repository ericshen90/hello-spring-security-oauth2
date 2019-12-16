package com.eric.spring.security.oauth2.resource.service.impl;

import com.eric.spring.security.oauth2.resource.entity.TbContentCategory;
import com.eric.spring.security.oauth2.resource.dao.TbContentCategoryDao;
import com.eric.spring.security.oauth2.resource.service.TbContentCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 内容分类 服务实现类
 * </p>
 *
 * @author Eric Shen
 * @since 2019-12-13
 */
@Service
public class TbContentCategoryServiceImpl extends
    ServiceImpl<TbContentCategoryDao, TbContentCategory> implements TbContentCategoryService {

}
