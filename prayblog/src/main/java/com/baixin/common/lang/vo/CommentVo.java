package com.baixin.common.lang.vo;

import com.baixin.entity.Comment;
import lombok.Data;

@Data
public class CommentVo  extends Comment  {
    private Long authorId;
    private String authorName;
    private String authorAvatar;
}
