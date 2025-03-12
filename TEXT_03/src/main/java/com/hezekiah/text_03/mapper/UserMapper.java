package com.hezekiah.text_03.mapper;


import com.hezekiah.text_03.entity.domain.User;
import com.hezekiah.text_03.entity.params.CustomerParams;
import com.hezekiah.text_03.entity.params.UserParams;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    User findByAccount(@Param("account") String account);

    void addUserRegister(@Param("user") User user);

    void insertUser(UserParams userParams);

    void insertCustomer(CustomerParams customerParams);

}