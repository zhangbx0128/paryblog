package com.baixin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baixin.service.*;
import com.baixin.shiro.AccountProfile;

import org.apache.shiro.SecurityUtils;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.ServletRequestUtils;

import javax.servlet.http.HttpServletRequest;

public class BaseController {
    @Autowired
    HttpServletRequest req;

    @Autowired
    PostService postService;

    @Autowired
    CommentService commentService;

    @Autowired
    UserService userService;

    @Autowired
    UserMessageService messageService;

    @Autowired
    UserCollectionService collectionService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    WsService wsService;

    @Autowired
    SearchService searchService;

    @Autowired
    AmqpTemplate amqpTemplate;

    @Autowired
    ChatService chatService;

    public Page getPage() {
        int pn = ServletRequestUtils.getIntParameter(req, "pn", 1);
        int size = ServletRequestUtils.getIntParameter(req, "size", 2);
        return new Page(pn, size);
    }

    protected AccountProfile getProfile() {
        return (AccountProfile) SecurityUtils.getSubject().getPrincipal();
    }

    protected Long getProfileId() {
        return getProfile().getId();
    }

}
