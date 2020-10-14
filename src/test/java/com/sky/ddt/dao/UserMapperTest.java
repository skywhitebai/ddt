package com.sky.ddt.dao;


import com.sky.ddt.dao.generate.UserMapper;
import com.sky.ddt.entity.UserExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
@Transactional
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void test0(){
        System.out.println("第一个测试方法*******");
        System.out.println(userMapper.countByExample(new UserExample()));
    }
}
