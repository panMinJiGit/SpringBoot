package com.cc.springboot.controller;

import com.cc.springboot.entity.UserEntity;
import com.cc.springboot.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserMapper userMapper;

   /* @Autowired
    StringEncryptor encryptor;*/

    @RequestMapping("/list")
    @ResponseBody
    List<UserEntity> listAll(){
        logger.info("-----------请求listInfo....");
        List<UserEntity> userList = this.userMapper.selectAll();

        return  userList;

    }

    @RequestMapping("/encrypt")
    public void encrypt(){

        /*System.out.println("-----------------encrypt -> ResultData....");
        String url = encryptor.encrypt("jdbc:mysql://47.105.200.6:3306/bolodan_cc?useUnicode=true&characterEncoding=utf8");
        String username = encryptor.decrypt("admin");
        String password = encryptor.decrypt("admin123");
        System.out.println(url);
        System.out.println(username);
        System.out.println(password);*/

    }

}
