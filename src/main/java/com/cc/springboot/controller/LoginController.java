package com.cc.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(){
        System.out.println("------------login------------");
        return "demo_1/index";
    }

    @RequestMapping("/")
    public String loginIndex(){
        System.out.println("------------访问8082.....");
        return "demo_1/index";
    }
}
