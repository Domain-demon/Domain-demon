package com.hezekiah.text_03;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hezekiah.text_03.mapper")
public class Text03Application {

    public static void main(String[] args) {
        SpringApplication.run(Text03Application.class, args);
    }

}
