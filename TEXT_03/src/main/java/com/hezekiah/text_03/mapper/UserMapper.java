package com.hezekiah.text_03.mapper;


import com.hezekiah.text_03.entity.domain.User;
import com.hezekiah.text_03.entity.params.CustomerParams;
import com.hezekiah.text_03.entity.params.MerchantParams;
import com.hezekiah.text_03.entity.params.TakerParams;
import com.hezekiah.text_03.entity.params.UserParams;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    User findByAccount(@Param("account") String account);

    User findInfoByAccount(@Param("account") String account);

    void addUserRegister(@Param("user") User user);

    void insertUser(UserParams userParams);

    void insertCustomer(CustomerParams customerParams);

    void insertTaker(TakerParams takerParams);

    void insertMerchant(MerchantParams merchantParams);

}