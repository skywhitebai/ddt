package com.sky.ddt.controller;

import com.sky.ddt.common.annotation.Action;
import com.sky.ddt.common.annotation.Login;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.test.DateTestRequest;
import com.sky.ddt.util.ExcelUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

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
}
