package com.sky.ddt.controller.amazon;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.Action;
import com.sky.ddt.common.annotation.Login;
import com.sky.ddt.controller.SuperController;
import com.sky.ddt.dto.amazon.AmazonConfig;
import com.sky.ddt.dto.amazon.amazonAuth.request.ListAmazonAuthRequest;
import com.sky.ddt.dto.amazon.amazonAuth.request.SaveAmazonAuthRequest;
import com.sky.ddt.dto.amazon.amazonAuth.response.ListAmazonAuthResponse;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.service.amazon.IAmazonAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author baixueping
 * @description 亚马逊控制器
 * @date 2021/6/24 11:01
 */
@RestController
@RequestMapping("/amazonAuth")
public class AmazonAuthController extends SuperController {
    @Autowired
    IAmazonAuthService amazonAuthService;
    @RequestMapping("/index")
    public String index() {
        return "amazon/amazonAuth/list";
    }
    @RequestMapping("/listAmazonAuth")
    public DataGridResponse listAmazonAuth(@Validated ListAmazonAuthRequest params){
        PageInfo<ListAmazonAuthResponse> page = amazonAuthService.listAmazonAuth(params);
        DataGridResponse dataGridResponse = new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }
    @RequestMapping("/saveAmazonAuth")
    public BaseResponse saveAmazonAuth(@Validated SaveAmazonAuthRequest params){
        return amazonAuthService.saveAmazonAuth(params,getCurrentUserId());
    }
    @RequestMapping("/getAmazonAuthConfig")
    @Login(action = Action.Skip)
    public BaseResponse getAmazonAuthConfig(){
        return BaseResponse.successData(AmazonConfig.INSTANCE);
    }
}
