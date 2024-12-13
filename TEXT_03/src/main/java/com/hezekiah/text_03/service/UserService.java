package com.hezekiah.text_03.service;

import com.hezekiah.text_03.entity.domain.User;
import com.hezekiah.text_03.entity.params.LoginParams;
import com.hezekiah.text_03.mapper.UserMapper;
import com.hezekiah.text_03.utils.HttpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {
//注⼊
    @Autowired
    private UserMapper userMapper;


    public Map<String, Object> getUserByAccount(LoginParams loginParams){
        User user = userMapper.findByAccount(loginParams.getAccount());
        if (user == null){return HttpResult.error("查无账号",null);}
        else if (!user.getPassword().equals(loginParams.getPassword())){return HttpResult.error( "密码错误",null);}
        else {return HttpResult.success("登录成功",null);}
    }

//    public User addUserRegister(String account, String password){
//        return userMapper.addUserRegister(account, password);
//    }

    public Map<String, Object> addUserRegister(LoginParams loginParams){
        User user = userMapper.findByAccount(loginParams.getAccount());
        if (user == null){
            // 执行插入操作
            User newUser = new User();
            newUser.setAccount(loginParams.getAccount());
            newUser.setPassword(loginParams.getPassword());
            userMapper.addUserRegister(newUser);
            return HttpResult.success( "注册成功",null);
        }
        else {return HttpResult.error( "账号已存在，注册失败",null);}
    }



}

