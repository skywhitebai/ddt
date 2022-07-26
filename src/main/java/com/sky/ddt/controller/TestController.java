package com.sky.ddt.controller;

import com.sky.ddt.common.annotation.Action;
import com.sky.ddt.common.annotation.Login;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.test.DateTestRequest;
import com.sky.ddt.dto.test.GetLocalDateTimeRequest;
import com.sky.ddt.util.ExcelUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("test")
public class TestController extends SuperController {
    @RequestMapping("/readExcel")
    @Login(action = Action.Skip)
    @ResponseBody
    public List<Map<String, String>> readExcel(MultipartFile file) {
        List<Map<String, String>> res = ExcelUtil.getListByExcel(file);
        return res;
    }

    @RequestMapping("/testDate")
    @Login(action = Action.Skip)
    @ResponseBody
    public BaseResponse testDate(DateTestRequest params) {
        return BaseResponse.successData(params);
    }

    @RequestMapping("/getLocalDateTime")
    @Login(action = Action.Skip)
    @ResponseBody
    public BaseResponse getLocalDateTime(@RequestBody GetLocalDateTimeRequest prams) {
        return BaseResponse.successData(prams);
    }

    @RequestMapping("/testException")
    @Login(action = Action.Skip)
    @ResponseBody
    public BaseResponse testException() {
        Integer a = null;
        return BaseResponse.successData(0/a);
    }
    @RequestMapping("/testLong")
    @Login(action = Action.Skip)
    @ResponseBody
    public Long testLong() {
        return 1234567891234567891L;
    }



    @RequestMapping("/testUuid")
    @Login(action = Action.Skip)
    @ResponseBody
    public String testUuid() {
        String uuid=UUID.randomUUID().toString();
        return uuid;
    }

}
