package com.sky.ddt.controller.sys;

import com.sky.ddt.common.annotation.Log;
import com.sky.ddt.controller.SuperController;
import com.sky.ddt.dto.easyui.response.MenuRightTreeResponse;
import com.sky.ddt.dto.easyui.response.MenuTree;
import com.sky.ddt.dto.easyui.response.TreeGridResponse;
import com.sky.ddt.dto.easyui.response.TreeResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.sys.menu.request.SaveMenuRequest;
import com.sky.ddt.dto.sys.menu.response.MenuTreeResponse;
import com.sky.ddt.service.sys.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baixueping
 * @description 菜单管理
 * @date 2019/6/12 14:44
 */
@Controller
@RequestMapping("/menu")
public class MenuController extends SuperController{
    @Autowired
    IMenuService menuService;
    @RequestMapping("/index")
    public String index() {
        return "sys/menu/list";
    }

    @RequestMapping("/treegrid")
    @ResponseBody
    @Log("获取菜单列表")
    public TreeGridResponse<MenuTreeResponse> treegrid() {
        MenuTreeResponse menuTreeResponse=menuService.treegrid();
        TreeGridResponse<MenuTreeResponse> treeResponseTreeGridResponse=new TreeGridResponse<>();
        List<MenuTreeResponse> list=new ArrayList<MenuTreeResponse>();
        list.add(menuTreeResponse);
        treeResponseTreeGridResponse.setRows(list);
        treeResponseTreeGridResponse.setTotal(1L);
        return treeResponseTreeGridResponse;
    }
    @RequestMapping("/combotree")
    @ResponseBody
    @Log("获取菜单下拉")
    public List<MenuTreeResponse> combotree() {
        MenuTreeResponse menuTreeResponse=menuService.treegrid();
        List<MenuTreeResponse> list=new ArrayList<>();
        list.add(menuTreeResponse);
        return list;
    }
    @RequestMapping("/save")
    @ResponseBody
    @Log("保存菜单")
    public BaseResponse save(@Validated SaveMenuRequest params) {
        Integer dealUserId=getCurrentUserId();
        return menuService.save(params,dealUserId);
    }
    @RequestMapping("/delete")
    @ResponseBody
    @Log("删除菜单")
    public BaseResponse delete(@RequestParam(required = false, value = "ids[]") List<Integer> ids) {
        Integer dealUserId=getCurrentUserId();
        return menuService.delete(ids,dealUserId);
    }
    @RequestMapping("/tree")
    @ResponseBody
    @Log("菜单树 供角色选择菜单")
    public  List<TreeResponse> tree() {
        return menuService.tree();
    }

    /**
     * @param
     * @return
     * @description 菜单权限树，供角色选菜单和权限
     * @author baixueping
     * @date 2020/9/25 17:14
    */
    @RequestMapping("/menuRightTree")
    @ResponseBody
    @Log("菜单树 供角色选择菜单")
    public  List<MenuRightTreeResponse> menuRightTree() {
        return menuService.menuRightTree();
    }

    @RequestMapping("/menuTree")
    @ResponseBody
    @Log("获取当前用户菜单")
    public  List<MenuTree> menuTree() {
        return menuService.menuTree(getCurrentUserId());
    }
}
