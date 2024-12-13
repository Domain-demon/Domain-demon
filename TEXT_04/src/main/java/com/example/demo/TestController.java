package com.example.demo;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.*;

@RequestMapping("/test")
@Controller
@CrossOrigin
public class TestController {


    @GetMapping("/register")
    @ResponseBody
    public static String register(String account, String password) throws ClassNotFoundException, SQLException {

        //链接
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "xhq030218");

        //操作数据
        //查询
//        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM `user`");
        //查询结果
//        ResultSet resultSet = preparedStatement.executeQuery();

        //添加
        PreparedStatement preparedStatement = connection.prepareStatement("insert into `user` (account, `password`) values (?,?)");
        preparedStatement.setString(1, account);
        preparedStatement.setString(2, password);
        //影响行数
        int rows = preparedStatement.executeUpdate();

        String result = " ";
        if (rows > 0) {
            result = "注册成功";
        }else {
            result = "注册失败";
        }

        preparedStatement.close();
        connection.close();

        return result;



//        while (resultSet.next()) {
//            String id = resultSet.getString("id");
//            String name = resultSet.getString("username");
//            String password = resultSet.getString("password");
//            int score = resultSet.getInt("score");
//            System.out.println(id + " " + name + " " + password + " " + score);
//        }



    }

}
