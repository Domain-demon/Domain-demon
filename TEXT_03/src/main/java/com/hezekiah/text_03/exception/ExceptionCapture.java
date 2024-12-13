package com.hezekiah.text_03.exception;


import com.hezekiah.text_03.utils.HttpResult;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;
import java.util.stream.Collectors;


//@RestControllerAdvice 是 Spring 框架中的一个用于统一处理控制器异常和返回结果的注解，它可以被用来定义全局异常处理程序和全局响应结果处理程序
@RestControllerAdvice
public class ExceptionCapture {
    /**
     * 自定义验证异常
     * - 自定义参数校验异常，将message按照统一的HttpResult封装格式返回前端
     ***/
    @ExceptionHandler(BindException.class)
    public Map<String ,Object> handleBindException(BindException e) {
        //获取所有未通过校验的message的第一条
//       String message = e.getAllErrors().get(0).getDefaultMessage();


        // 获取所有校验失败消息
        String errorMessages = e.getFieldErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining(", "));

        // 返回合并后的错误信息
        return HttpResult.error(errorMessages, null);
    }

}

