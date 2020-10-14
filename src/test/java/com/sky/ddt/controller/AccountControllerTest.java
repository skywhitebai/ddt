package com.sky.ddt.controller;

import com.sky.ddt.BaseControllerTest;
import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

public class AccountControllerTest extends BaseControllerTest {
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
