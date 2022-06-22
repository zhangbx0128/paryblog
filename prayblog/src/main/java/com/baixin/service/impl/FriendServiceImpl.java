package com.baixin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baixin.entity.Friend;
import com.baixin.mapper.FriendMapper;
import com.baixin.service.FriendService;
import org.springframework.stereotype.Service;

/**
 * 服务实现类
 *
 * @author: baixin
 * @date: 2022/6/11
 */
@Service
public class FriendServiceImpl extends ServiceImpl<FriendMapper, Friend> implements FriendService {

}
