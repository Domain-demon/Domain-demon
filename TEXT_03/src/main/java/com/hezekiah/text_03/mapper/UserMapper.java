package com.hezekiah.text_03.mapper;


import com.hezekiah.text_03.entity.domain.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
//    List<User> getUserList();

    User findByAccount(@Param("account") String account);

//    User addUserRegister(@Param("account") String account, @Param("password") String password);

//    User addUserRegister(@Param("user") User user);

    void addUserRegister(@Param("user") User user);
}