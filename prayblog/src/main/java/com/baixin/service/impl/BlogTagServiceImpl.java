package com.baixin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baixin.entity.BlogTag;
import com.baixin.mapper.BlogTagMapper;
import com.baixin.service.BlogTagService;
import org.springframework.stereotype.Service;

/**
 * 服务实现类
 *
 * @author: baixin
 * @date: 2022/6/11
 */
@Service
public class BlogTagServiceImpl extends ServiceImpl<BlogTagMapper, BlogTag> implements BlogTagService {

}
