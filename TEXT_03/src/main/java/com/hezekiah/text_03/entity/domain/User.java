package com.hezekiah.text_03.entity.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data是Lombok库提供的⼀个注解,它主要⽤于简化 Java 类的代码
@Data
//@AllArgsConstructor:⽣成该类下全部属性的构造⽅法
@AllArgsConstructor
// @NoArgsConstructor:⽣成⽆参的构造⽅法
@NoArgsConstructor
public class User {
    int userId;
    String userName;
    String account;
    String password;
    String roleId;
}