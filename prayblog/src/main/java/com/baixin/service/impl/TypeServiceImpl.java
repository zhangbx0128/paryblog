package com.baixin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baixin.entity.Type;
import com.baixin.mapper.TypeMapper;
import com.baixin.service.TypeService;
import org.springframework.stereotype.Service;

/**
 * 服务实现类
 *
 * @author: baixin
 * @date: 2022/6/11
 */
@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type> implements TypeService {

}
