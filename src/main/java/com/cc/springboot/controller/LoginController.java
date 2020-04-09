package com.cc.springboot.controller;

import com.cc.springboot.entity.UserInfoEntity;
import com.cc.springboot.utils.MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
//解决跨域问题
@CrossOrigin(allowCredentials="true",allowedHeaders="*")
public class LoginController {

    private final static Logger logger = LoggerFactory.getLogger(LoginController.class);

    /**
     * 验证用户登录信息
     * @param request
     * @param response
     * @param session
     * @param username
     * @param password
     * @return
     * @throws IOException
     */
    @RequestMapping("/login")
    @ResponseBody
    public Map login(HttpServletRequest request, HttpServletResponse response, HttpSession session, String username, String password) {
        logger.info("后台验证用户登录信息");
        logger.info("获取用户名:"+username);
        logger.info("获取用户密码:"+password);
        logger.info("密码加密:"+ MD5Util.md5DigestAsHex(password));
        Map<String,Object> map = new HashMap<String, Object>();
        UserInfoEntity loginUser = new UserInfoEntity();
        if(username.equals("admin") && password.equals("admin123")){
            loginUser.setUserName(username);
            loginUser.setPassword(password);
            session.setAttribute("loginUser",loginUser);
            logger.info("登录成功");
            map.put("msg","登录成功");
            map.put("status",200);
            //response.sendRedirect("/index");
            return map;
        }else{
            logger.info("登录失败，用户名或密码不对");
            map.put("msg","用户名或密码不对");
            map.put("status",400);
        }
        return map;
    }

}
