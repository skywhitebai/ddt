package com.sky.ddt.controller.sys;

import com.sky.ddt.controller.SuperController;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.RoleRight;
import com.sky.ddt.service.sys.IRoleRightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author baixueping
 * @description 角色权限控制器
 * @date 2020/9/27 14:00
 */
@Controller
@RequestMapping("/roleRight")
public class RoleRightController extends SuperController {
    @Autowired
    IRoleRightService roleRightService;
    @RequestMapping("/roleRightList")
    @ResponseBody
    public BaseResponse<List<RoleRight>> roleRightList(Integer roleId) {
        return roleRightService.roleRightList(roleId);
    }

}
