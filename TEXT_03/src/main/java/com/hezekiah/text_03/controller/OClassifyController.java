package com.hezekiah.text_03.controller;

import com.hezekiah.text_03.service.OClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

//跨域
@CrossOrigin
//初始化
@RestController
//根路径
@RequestMapping("/order")
public class OClassifyController {
    //注⼊
    @Autowired
    private OClassifyService oClassifyService;


    //请求类型
    @GetMapping("/getAllClassify")
    public Map<String, Object> getAllClassify() {
        return oClassifyService.getAllClassify();
    }
}
