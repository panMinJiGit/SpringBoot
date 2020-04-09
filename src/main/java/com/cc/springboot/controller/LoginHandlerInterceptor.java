package com.cc.springboot.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录拦截器
 * 用登录检查验证
 * @author panMinJi
 * @date 2020年4月2日18:23:10
 */
@Component
public class LoginHandlerInterceptor implements HandlerInterceptor {

    /**
     * 拦截请求路径验证用户登录时间是否过期，如过期需要重新登录认证
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginUser = request.getSession().getAttribute("loginUser");
        System.out.println("------被拦截访问路径:"+request.getRequestURI());
        System.out.println("loginUser:"+loginUser);
        //获取session
        HttpSession session = request.getSession(true);
        if (loginUser == null || loginUser.equals(""))  {
            response.sendRedirect("/");
            return false;
        }else {
            session.setAttribute("loginUser",loginUser);
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }


}
