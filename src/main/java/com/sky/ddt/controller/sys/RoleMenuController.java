package com.sky.ddt.controller.sys;

import com.sky.ddt.controller.SuperController;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.sys.rolemenu.request.SaveRoleMenuRequest;
import com.sky.ddt.entity.RoleMenu;
import com.sky.ddt.service.sys.IRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author baixueping
 * @description 角色菜单
 * @date 2019/6/20 16:44
 */
@RequestMapping("/roleMenu")
@Controller
public class RoleMenuController extends SuperController {
    @Autowired
    IRoleMenuService roleMenuService;

    @RequestMapping("/roleMenuList")
    @ResponseBody
    public BaseResponse<List<RoleMenu>> roleMenuList(Integer roleId) {
        return roleMenuService.roleMenuList(roleId);
    }

    @RequestMapping("/save")
    @ResponseBody
    public BaseResponse save(Integer roleId, @RequestParam(required = false, value = "menuIds[]") List<Integer> menuIds) {
        return roleMenuService.save(roleId, menuIds, getCurrentUserId());
    }
    @RequestMapping("/saveRoleMenuRight")
    @ResponseBody
    public BaseResponse saveRoleMenuRight(Integer roleId, @RequestParam(required = false, value = "menuRightIds[]") List<String> menuRightIds) {
        return roleMenuService.saveRoleMenuRight(roleId, menuRightIds, getCurrentUserId());
    }

}
