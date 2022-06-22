package com.baixin.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * MybatisPlus配置
 *
 * @author: baixin
 * @date: 2022/6/11
 */
@Configuration
@EnableTransactionManagement
@MapperScan("com.baixin.mapper")
public class MybatisPlusConfig {
    /**
     * 分页插件
     * 在高版本的SpringBoot中, 会提示这种写法已过时, 所以采用另一种写法 MybatisPlusInterceptor , 如下:
     * @Bean
     * public MybatisPlusInterceptor mybatisPlusInterceptor() {
     *     MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
     *     interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.H2));
     *     return interceptor;
     * }
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        return paginationInterceptor;
    }
}

