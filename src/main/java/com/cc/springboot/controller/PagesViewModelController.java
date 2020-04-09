package com.cc.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转Comtroller
 */
@Controller
@RequestMapping("/demo_1/pages")
public class PagesViewModelController {

    @RequestMapping("/login/register")
    public String register(){

        return "demo_1/pages/login/register";
    }
}
