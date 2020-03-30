package com.cc.springboot;

import com.cc.springboot.entity.UserEntity;
import com.cc.springboot.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        System.out.println("-------@Test");


       List<UserEntity> list = userMapper.selectAll();
        System.out.println(list);
        list.forEach(s -> System.out.println(s.getDeviceImei() + " VS " + s.getDeviceName()));



    }

}
