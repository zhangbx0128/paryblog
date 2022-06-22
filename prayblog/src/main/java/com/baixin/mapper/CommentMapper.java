package com.baixin.mapper;

import com.baixin.common.lang.vo.CommentVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baixin.common.lang.vo.PageComment;
import com.baixin.entity.Comment;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author: baixin
 * @date: 2022/6/11
 */
@Mapper
@Repository
public interface CommentMapper extends BaseMapper<Comment> {

    /**
     * 根据创建时间倒序 根据博客id和父评论id查询所有子评论
     */
    @Select("select id, nickname, content, website,avatar, create_time, is_admin_comment,parent_comment_nickname  from comment where blog_id=#{blogId} and parent_comment_id=#{parentCommentId} order by create_time desc")
    List<PageComment> getPageCommentListByPageAndParentCommentIdByDesc(@Param("blogId") long blogId, @Param("parentCommentId") long parentCommentId);

    /**
     * 根据博客id和父评论id查询所有子评论
     */
    @Select("select id, nickname, content, website,avatar, create_time, is_admin_comment,parent_comment_nickname  from comment where blog_id=#{blogId} and parent_comment_id=#{parentCommentId} order by create_time")
    List<PageComment> getPageCommentListByPageAndParentCommentId(@Param("blogId") long blogId, @Param("parentCommentId") long parentCommentId);


    IPage<CommentVo> selectComments(Page page, QueryWrapper<Comment> orderByDesc);
}
