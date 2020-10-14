package com.sky.ddt.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sky.ddt.BaseTest;
import com.sky.ddt.dto.response.BaseResponse;
import org.junit.Test;

/**
 * 普通测试
 */
public class Test1  {
    @Test
    public void test0(){
        System.out.println("第一个测试方法*******");
    }
    @Test
    public void test2(){
        String response="{1111\"reason\":\"未知异常\"1111\"reason\":\"未知异常\"1111\"reason\":\"未知异常\"1111\"reason\":\"未知异常\"}";
        System.out.println(response.indexOf("\"reason\":\"未知异常\""));
        int repeatTimes=0;
        while(repeatTimes<5&&response.indexOf("\"reason\":\"未知异常\"")>0){
            System.out.println(repeatTimes);
            repeatTimes++;
        }
    }
    @Test
    public void test3(){
        BaseResponse baseResponse=new BaseResponse();
        baseResponse.setCode("123");
        System.out.println(JSON.toJSONString(baseResponse));
        System.out.println(JSONObject.toJSONString(baseResponse));
    }
    @Test
    public void appendTest(){
        StringBuilder sb=new StringBuilder();
        String a=null;
        sb.append("ad").append(a);
        System.out.println(sb.toString());
    }
}
