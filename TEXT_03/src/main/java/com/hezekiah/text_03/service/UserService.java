package com.hezekiah.text_03.service;

import com.hezekiah.text_03.entity.domain.User;
import com.hezekiah.text_03.entity.params.*;
import com.hezekiah.text_03.mapper.UserMapper;
import com.hezekiah.text_03.utils.HttpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
public class UserService {
    //注⼊
    @Autowired
    private UserMapper userMapper;


    public Map<String, Object> getUserByAccount(LoginParams loginParams) {
        User user = userMapper.findByAccount(loginParams.getAccount());
        if (user == null) {
            return HttpResult.error("查无账号", null);
        } else if (!user.getPassword().equals(loginParams.getPassword())) {
            return HttpResult.error("密码错误", null);
        } else {
            User userInfo = userMapper.findInfoByAccount(loginParams.getAccount());
            return HttpResult.success("登录成功", userInfo);
        }
    }


    public Map<String, Object> addUserRegister(LoginParams loginParams) {
        User user = userMapper.findByAccount(loginParams.getAccount());
        if (user != null) {
            return HttpResult.error("账号已存在", null);
        } else {
            // 执行插入操作
            User newUser = new User();
            newUser.setAccount(loginParams.getAccount());
            newUser.setPassword(loginParams.getPassword());
            newUser.setUserName("新用户" + loginParams.getAccount());
            userMapper.addUserRegister(newUser);
            User userInfo = userMapper.findInfoByAccount(loginParams.getAccount());
            return HttpResult.success("注册成功", userInfo);

        }
    }

    @Transactional
    public Map<String, Object> addCustomerRegister(CustomerParamsDto customerParamsDto) {
        UserParams userParams = customerParamsDto.getUserParams();
        int userId = userParams.getUserId();

        CustomerParams customerParams = customerParamsDto.getCustomerParams();
        customerParams.setUserId(userId);
        userMapper.insertCustomer(customerParams);
        return HttpResult.success("注册成功", null);
    }


    @Transactional
    public Map<String, Object> addTakerRegister(TakerParamsDto takerParamsDto) {
        UserParams userParams = takerParamsDto.getUserParams();
        User user = userMapper.findByAccount(userParams.getAccount());
        if (user != null) {
            return HttpResult.error("账号已存在", null);
        } else {
            userMapper.insertUser(userParams);
            User userInfo = userMapper.findInfoByAccount(userParams.getAccount());
            TakerParams takerParams = takerParamsDto.getTakerParams();
            takerParams.setUserId(userInfo.getUserId());
            userMapper.insertTaker(takerParams);
            return HttpResult.success("注册成功", userInfo);
        }

    }

    @Transactional
    public Map<String, Object> addMerchantRegister(MerchantParamsDto merchantParamsDto) {
        UserParams userParams = merchantParamsDto.getUserParams();
        User user = userMapper.findByAccount(userParams.getAccount());
        if (user != null) {
            return HttpResult.error("账号已存在", null);
        } else {
            userMapper.insertUser(userParams);
            User userInfo = userMapper.findInfoByAccount(userParams.getAccount());
            MerchantParams merchantParams = merchantParamsDto.getMerchantParams();
            merchantParams.setUserId(userInfo.getUserId());
            userMapper.insertMerchant(merchantParams);
            return HttpResult.success("注册成功", userInfo);
        }

    }
}

