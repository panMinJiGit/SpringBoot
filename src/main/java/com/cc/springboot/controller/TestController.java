package com.cc.springboot.controller;
import com.cc.springboot.redis.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {


    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    @Autowired
    private RedisUtil redisUtils;

    /**
     * 引入日志，注意都是"org.slf4j"包下
     */
    private final static Logger logger = LoggerFactory.getLogger(TestController.class);


    @RequestMapping("/index")
    public String index(){
        logger.info("-----test值离过期时间还有："+ redisUtils.getExpire("test") + "秒");
        logger.info("test:"+redisUtils.get("test"));

        return "hello word !";
    }

    @RequestMapping("/info")
    public String infoPrint(){
        //日志级别由高到低是：fatal -> error -> warn -> info -> debug,低级别的会输出高级别的信息，高级别的不会输出低级别的
       /* logger.info("-------------------正常业务处理日志打印...");
        logger.error("------------------错误业务处理日志打印...");
        logger.debug("------------------业务遇到BUG级别日志打印..");
        logger.warn("-------------------这是什么日志wht?");*/

        redisUtils.set("test","555555555",60);

        return "进入后台打印信息...";
    }

}
