package com.baixin.controller;


import com.baixin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test {
    @Autowired

    UserService userService;
    @GetMapping("/test")
    public Object test(){
        return userService.list();
    }
}
