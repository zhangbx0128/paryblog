package com.baixin.service;

import com.baixin.common.lang.vo.CommentVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baixin.common.lang.vo.PageComment;
import com.baixin.entity.Comment;

import java.util.List;

/**
 * 服务类
 *
 * @author: baixin
 * @date: 2022/6/11
 */
public interface CommentService extends IService<Comment> {
    IPage<CommentVo> paing(Page page, Long postId, Long userId, String order);

    /**
     * 通过博客id和父评论id查找所有子评论 并按照时间倒序排序
     *
     * @param blogId
     * @param parentCommentId
     * @return
     */
    public List<PageComment> getPageCommentListByDesc(Long blogId, Long parentCommentId);

    /**
     * 通过博客id和父评论id查找所有子评论
     *
     * @param blogId
     * @param parentCommentId
     * @return
     */
    public List<PageComment> getPageCommentList(Long blogId, Long parentCommentId);
}
