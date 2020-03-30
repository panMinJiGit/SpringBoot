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

    @RequestMapping("/list")
    @ResponseBody
    List<UserEntity> listAll(){
        logger.info("-----------请求listInfo....");
        List<UserEntity> userList = this.userMapper.selectAll();

        return  userList;

    }

}
