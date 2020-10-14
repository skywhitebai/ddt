package com.sky.ddt.controller.sys;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.controller.SuperController;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.userrole.request.GetUserRolesRequest;
import com.sky.ddt.dto.userrole.request.UserRoleSaveRequest;
import com.sky.ddt.dto.userrole.response.UserRoleResponse;
import com.sky.ddt.service.sys.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * @author baixueping
 * @description 用户角色管理
 * @date 2019/6/12 15:40
 */
@Controller
@RequestMapping("/userRole")
public class UserRoleController extends SuperController{

    @Autowired
    IUserRoleService userRoleService;

    @RequestMapping("getUserRoles")
    @ResponseBody
    public DataGridResponse getUserRoles(GetUserRolesRequest params) {
        PageInfo<UserRoleResponse> page = userRoleService.getUserRoles(params);
        DataGridResponse dataGridResponse = new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }
    @RequestMapping("delete")
    @ResponseBody
    public BaseResponse delete(@RequestParam(required = false, value = "ids[]") List<Integer> ids) {
        return userRoleService.delete(ids);
    }
    @RequestMapping("save")
    @ResponseBody
    public BaseResponse save(@Validated UserRoleSaveRequest params) {
        Integer dealUserId=getCurrentUserId();
        return userRoleService.save(params,dealUserId);
    }
}
