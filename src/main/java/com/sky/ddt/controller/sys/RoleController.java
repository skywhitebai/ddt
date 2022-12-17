package com.sky.ddt.controller.sys;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.annotation.Log;
import com.sky.ddt.controller.SuperController;
import com.sky.ddt.dto.easyui.request.DataGridRequest;
import com.sky.ddt.dto.easyui.response.DataGridResponse;
import com.sky.ddt.dto.easyui.response.TreeResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.sys.role.request.RoleSaveRequest;
import com.sky.ddt.dto.user.request.UserTreeReq;
import com.sky.ddt.entity.Role;
import com.sky.ddt.service.sys.IRoleService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author baixueping
 * @description 角色管理
 * @date 2019/6/13 15:46
 */
@Data
@Controller
@RequestMapping("/role")
public class RoleController extends SuperController {
    @Autowired
    IRoleService roleService;

    @RequestMapping("/comboboxlist")
    @ResponseBody
    public List<Role> comboboxlist() {
        List<Role> list = roleService.comboboxlist();
        return list;
    }
    @RequestMapping("/index")
    public String index() {
        return "sys/role/list";
    }
    @RequestMapping("list")
    @ResponseBody
    public DataGridResponse list(DataGridRequest params) {
        PageInfo<Role> page=roleService.list(params);
        DataGridResponse dataGridResponse=new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }
    @RequestMapping("save")
    @ResponseBody
    public BaseResponse save(RoleSaveRequest params) {
        Integer dealUserId=getCurrentUserId();
        return roleService.save(params,dealUserId);
    }
    @RequestMapping("delete")
    @ResponseBody
    public BaseResponse delete(Integer id) {
        return roleService.delete(id);
    }

    @RequestMapping("/tree")
    @ResponseBody
    public  List<TreeResponse> tree() {
        return roleService.tree();
    }
}
