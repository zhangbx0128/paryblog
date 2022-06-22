package com.baixin.shiro;

import lombok.Data;

import java.io.Serializable;

/**
 * 账户信息实体类
 *
 * @author: baixin
 * @date: 2022/6/11
 */
@Data
public class AccountProfile implements Serializable {
    private Long id;
    private String username;
    private String avatar;
    private String role;
}


