package com.sky.ddt.controller;

import com.sky.ddt.BaseControllerTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath*:/spring-mvc.xml","classpath*:spring-mybatis.xml"})
public class AccountControllerTest2  {
    @Autowired
    public WebApplicationContext wac;

    public MockMvc mockMvc;

    @Before
    public void setup()  {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }
    @Test
    public void testHelloWorld() throws Exception {
        ResultActions  resultActions=mockMvc.perform(get("/account/test"));
        MvcResult mvcResult = resultActions.andReturn();
        System.out.println("status :\t" + mvcResult.getResponse().getStatus());
        String resposne = mvcResult.getResponse().getContentAsString();
        System.out.println("reponse :\t" + resposne);
    }

//    @Test
//    public void add() {
//        try {
//            ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.post("http://127.0.0.1/zb.waiter/16/org/").
//                    accept(MediaType.APPLICATION_JSON).
//                    param("name", "武昌").
//                    param("fid", "0").
//                    param("tree_level", "2").
//                    param("route", "1-").
//                    param("mall_name", "众包客服").
//                    param("is_leaf", "true"));
//
//            MvcResult mvcResult = resultActions.andReturn();
//            System.out.println("status :\t" + mvcResult.getResponse().getStatus());
//            String resposne = mvcResult.getResponse().getContentAsString();
//            System.out.println("reponse :\t" + resposne);
//        } catch (UnsupportedEncodingException e) {
//            log.error(e.getMessage(), e);
//        } catch (Exception e) {
//            log.error(e.getMessage(), e);
//        }
//    }
}
