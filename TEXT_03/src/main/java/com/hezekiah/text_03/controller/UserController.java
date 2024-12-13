package com.hezekiah.text_03.controller;

import com.hezekiah.text_03.entity.domain.User;
import com.hezekiah.text_03.entity.params.LoginParams;
import com.hezekiah.text_03.service.UserService;
import com.hezekiah.text_03.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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

//    @PostMapping("/login")
//    public Map<String,Object> login(@Validated LoginParams loginParams){
//        Map<String,Object> result = userService.login(loginParams);
//        if((int)result.get("code") == 200){
//            // 生成Token
//            String token = jwtUtils.generateToken(loginParams.getAccount());
//            result.put("token", token);
//        }
//        return result;
//    }
//
//    @PostMapping("/register")
//    public Map<String,Object> register(@Validated LoginParams loginParams){
//        // 注册成功后自动登录
//        Map<String,Object> result = userService.register(loginParams);
//        if((int)result.get("code") == 200){
//            String token = jwtUtils.generateToken(loginParams.getAccount());
//            result.put("token", token);
//        }
//        return result;
//    }
//
//    @Autowired
//    private JwtUtils jwtUtils;





}
