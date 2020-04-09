package com.cc.springboot.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Arrays;
import java.util.List;

/**
 * 扩展MVC
 * 配好拦截器，我们需要将拦截器交个WebMvc容器管理
 */
@Configuration
//@EnableWebMvc千万不能加，加了说明你是个冒牌货
public class WebmvcConfig extends WebMvcConfigurationSupport {

    private static final List<String> EXCLUDE_PATH= Arrays.asList("/","/css/**","/js/**","/images/**","/assets/**","/vendors/**","/demo_1/**");

    /**
     * 如果请求为"/",需要跳转到登录页面
     * @param registry
     */
    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("demo_1/pages/login/login");
    }

    /**
     * 配置拦截器 -> 拦截所有请求
     * @param registry
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns(EXCLUDE_PATH).excludePathPatterns("/user/login");
    }

    /**
     * 分析原因：添加了拦截器导致默认的register被覆盖，默认的静态资源位置也被覆盖
     * 解决办法：
     * 添加静态资源路径,不然会加载不了静态资源
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/resources/")
                .addResourceLocations("classpath:/static/")
                .addResourceLocations("classpath:/public/");
        super.addResourceHandlers(registry);
    }

}
