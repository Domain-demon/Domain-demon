package com.hezekiah.text_03.controller;

import com.hezekiah.text_03.entity.params.CustomerParamsDto;
import com.hezekiah.text_03.entity.params.LoginParams;
import com.hezekiah.text_03.entity.params.MerchantParamsDto;
import com.hezekiah.text_03.entity.params.TakerParamsDto;
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
    //登录
    @PostMapping("/login")
    public Map<String, Object> getUser(@Validated LoginParams loginParams) {
        return userService.getUserByAccount(loginParams);
    }


    //注册
    //通用
    @PostMapping("/register")
    public Map<String, Object> addUser(@Validated LoginParams loginParams) {
        return userService.addUserRegister(loginParams);
    }


    //客户
    @PostMapping("/customer")
    public Map<String, Object> addCustomer(@Validated @RequestBody CustomerParamsDto customerParamsDto) {
        return userService.addCustomerRegister(customerParamsDto);
    }


    //个体户
    @PostMapping("/taker")
    public Map<String, Object> addTaker(@Validated @RequestBody TakerParamsDto takerParamsDto) {
        return userService.addTakerRegister(takerParamsDto);
    }


    //公司
    @PostMapping("/merchant")
    public Map<String, Object> addMerchant(@Validated @RequestBody MerchantParamsDto merchantParamsDto) {
        return userService.addMerchantRegister(merchantParamsDto);
    }
}
