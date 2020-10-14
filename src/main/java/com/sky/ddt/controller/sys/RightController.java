package com.sky.ddt.controller.sys;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.MenuAnnotation;
import com.sky.ddt.controller.SuperController;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.sys.right.request.ListRightRequest;
import com.sky.ddt.dto.sys.right.request.SaveRightRequest;
import com.sky.ddt.dto.sys.right.request.UserRightListRequest;
import com.sky.ddt.entity.Right;
import com.sky.ddt.service.sys.IRightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author baixueping
 * @description 权限管理
 * @date 2020/9/22 16:23
 */
@RequestMapping("/right")
@RestController
public class RightController extends SuperController{

    @Autowired
    IRightService rightService;
    @ResponseBody
    @MenuAnnotation("menu/index")
    @RequestMapping("/listRight")
    public DataGridResponse listRight(ListRightRequest params) {
        PageInfo<Right> page = rightService.listRight(params);
        DataGridResponse dataGridResponse = new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }
    @ResponseBody
    @MenuAnnotation("menu/index")
    @RequestMapping("/saveRight")
    public BaseResponse saveRight(@Validated SaveRightRequest params) {
        Integer dealUserId = getCurrentUserId();
        return rightService.saveRight(params, dealUserId);
    }

    @ResponseBody
    @MenuAnnotation("menu/index")
    @RequestMapping("/deleteRight")
    public BaseResponse deleteRight(@RequestParam(required = false, value = "rightIds[]") List<Integer> rightIds) {
        return rightService.deleteRight(rightIds);
    }
    /**
     * @param
     * @return
     * @description 根据入参返回用户是否有权限
     * @author baixueping
     * @date 2020/9/27 16:01
    */
    @ResponseBody
    @RequestMapping("/userHasRight")
    public BaseResponse userHasRight(String rightStr){
        boolean res=rightService.userHasRight(getCurrentUserId(),rightStr);
        return BaseResponse.successData(res);
    }
    @ResponseBody
    @RequestMapping("/userRightList")
    public BaseResponse userRightList(UserRightListRequest params){
        params.setUserId(getCurrentUserId());
        return rightService.userRightList(params);
    }
}
