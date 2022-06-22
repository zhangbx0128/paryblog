package com.baixin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 评论实体类
 *
 * @author: baixin
 * @date: 2022/6/11
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)

public class Comment extends BaseEntity  {

    private static final long serialVersionUID = 1L;

//    @TableId(value = "id", type = IdType.AUTO)
//    private Long id;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 头像(图片路径)
     */
    private String avatar;

    /**
     * 评论时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 评论者ip地址
     */
    private String ip;

    /**
     * 博主回复
     */
    private Integer isAdminComment;
    /**
     * 公开或隐藏
     */
    private Boolean isPublished;

    /**
     * 所属的文章
     */
    private Long blogId;


    /**
     * 父评论昵称
     */
    private String parentCommentNickname;

    /**
     * 父评论id，-1为根评论
     */
    private Long parentCommentId;
    /**
     * 个人网站
     */
    private String website;
    /**
     * 如果评论昵称为QQ号，则将昵称和头像置为QQ昵称和QQ头像，并将此字段置为QQ号备份
     */
    private String qq;

    /**
     * 回复的评论ID
     */
    private Long parentId;

    /**
     * 评论的内容ID
     */
    private Long postId;

    /**
     * 评论的用户ID
     */
    private Long userId;

    /**
     * “顶”的数量
     */
    private Integer voteUp;

    /**
     * “踩”的数量
     */
    private Integer voteDown;

    /**
     * 置顶等级
     */
    private Integer level;


}
