package com.baixin.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * Jwt
 *
 * @author: baixin
 * @date: 2022/6/11
 */
public class JwtToken implements AuthenticationToken {
    private String token;

    public JwtToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}

