package com.baixin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baixin.common.lang.vo.BlogInfo;
import com.baixin.entity.Blog;
import org.apache.ibatis.annotations.Mapper;
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
public interface BlogMapper extends BaseMapper<Blog> {
    /**
     * 根据分类查询博客
     */
    List<BlogInfo> getBlogByTypeName(String typeName);

}
