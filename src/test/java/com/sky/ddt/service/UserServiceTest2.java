package com.sky.ddt.service;

import com.sky.ddt.BaseControllerTest;
import com.sky.ddt.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath*:/spring-mvc.xml","classpath*:spring-mybatis.xml"})
public class UserServiceTest2 {
    @Autowired
    public IUserService userService;

    @Test
    public  void getUserList() {
        System.out.println("123");
    }
}
