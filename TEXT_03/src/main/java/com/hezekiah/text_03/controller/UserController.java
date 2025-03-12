package com.hezekiah.text_03.controller;

import com.hezekiah.text_03.entity.params.CustomerParamsDto;
import com.hezekiah.text_03.entity.params.LoginParams;
import com.hezekiah.text_03.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

//跨域
@CrossOrigin
//初始化
@RestController
//根路径
@RequestMapping("/test")
public class UserController {
    //注⼊
    @Autowired
    private UserService userService;
    //请求类型
    @PostMapping("/login")
    public Map<String,Object> getUser(@Validated LoginParams loginParams){
        return userService.getUserByAccount(loginParams);
    }

    @PostMapping("/register")
    public Map<String,Object> addUser(@Validated LoginParams loginParams){
        return userService.addUserRegister(loginParams);
    }


    @PostMapping("/customer")
    public Map<String, Object> addCustomer(@Validated @ModelAttribute CustomerParamsDto customerParamsDto) {
        return userService.addCustomerRegister(customerParamsDto);
    }



}
