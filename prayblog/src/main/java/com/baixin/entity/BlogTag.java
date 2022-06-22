package com.baixin.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 博客标签实体类
 *
 * @author: baixin
 * @date: 2022/6/11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BlogTag implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long blogId;

    private Long tagId;


}
