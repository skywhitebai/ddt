package com.sky.ddt.controller;

import com.sky.ddt.common.annotation.Action;
import com.sky.ddt.common.annotation.Login;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.SysConfig;
import com.sky.ddt.service.ISysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 系统配置管理
 *
 * @author sky
 * @date 2019/3/26
 */
@Controller
@RequestMapping("config")
public class SysConfigController {

    @Autowired
    ISysConfigService sysConfigService;
    @RequestMapping("getConfigByKey")
    @ResponseBody
    @Login(action = Action.Skip)
    public BaseResponse<SysConfig> getConfigByKey(String keyName) {
        return sysConfigService.getConfigByKey(keyName);
    }
}
