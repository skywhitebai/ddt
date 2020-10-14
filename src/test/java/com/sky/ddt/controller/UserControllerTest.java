package com.sky.ddt.controller;

import com.sky.ddt.BaseControllerTest;
import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

public class UserControllerTest  extends BaseControllerTest {
    @Test
    public void testGetUserList() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/user/getUserList"));
        MvcResult mvcResult = resultActions.andReturn();
        System.out.println("status :\t" + mvcResult.getResponse().getStatus());
        String resposne = mvcResult.getResponse().getContentAsString();
        System.out.println("reponse :\t" + resposne);
    }
}
