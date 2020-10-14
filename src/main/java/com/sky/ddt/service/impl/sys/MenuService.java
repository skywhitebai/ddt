package com.sky.ddt.service.impl.sys;

import com.sky.ddt.common.constant.MenuConstant;
import com.sky.ddt.dao.custom.CustomMenuMapper;
import com.sky.ddt.dto.easyui.response.MenuRightTreeResponse;
import com.sky.ddt.dto.easyui.response.MenuTree;
import com.sky.ddt.dto.easyui.response.MenuTreeAttributes;
import com.sky.ddt.dto.easyui.response.TreeResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.sys.menu.request.SaveMenuRequest;
import com.sky.ddt.dto.sys.menu.response.MenuTreeResponse;
import com.sky.ddt.entity.Menu;
import com.sky.ddt.entity.MenuExample;
import com.sky.ddt.entity.Right;
import com.sky.ddt.service.sys.IMenuService;
import com.sky.ddt.service.sys.IRightService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author baixueping
 * @description 菜单服务
 * @date 2019/6/12 15:24
 */
@Service
public class MenuService implements IMenuService {

    @Autowired
    CustomMenuMapper customMenuMapper;
    @Autowired
    IRightService rightService;

    /**
     * @return
     * @description 获取菜单列表
     * @author baixueping
     * @date 2019/6/18 17:45
     */
    @Override
    public MenuTreeResponse treegrid() {
        MenuTreeResponse menuTreeResponse = new MenuTreeResponse();
        menuTreeResponse.setId(0);
        menuTreeResponse.setMenuName("菜单");
        List<Menu> menuList = getMenuAll();
        getTreegridChildren(menuTreeResponse, menuList);
        return menuTreeResponse;
    }

    /**
     * @param
     * @return
     * @description 获取所有菜单，并排序
     * @author baixueping
     * @date 2019/6/25 9:22
     */
    private List<Menu> getMenuAll() {
        MenuExample example = new MenuExample();
        example.setOrderByClause("sort asc");
        return customMenuMapper.selectByExample(example);
    }

    /**
     * @param
     * @return
     * @description 递归获取treegrid数据
     * @author baixueping
     * @date 2019/6/25 9:23
     */
    private void getTreegridChildren(MenuTreeResponse menuTreeResponse, List<Menu> menuList) {
        menuTreeResponse.setChildren(new ArrayList<MenuTreeResponse>());
        for (Menu menu : menuList) {
            if (menuTreeResponse.getId().equals(menu.getParentMenuId())) {
                MenuTreeResponse menuTreeChildren = new MenuTreeResponse();
                BeanUtils.copyProperties(menu, menuTreeChildren);
                getTreegridChildren(menuTreeChildren, menuList);
                menuTreeResponse.getChildren().add(menuTreeChildren);
            }
        }
    }

    /**
     * @param params
     * @param dealUserId
     * @return
     * @description 保存菜单
     * @author baixueping
     * @date 2019/6/19 14:49
     */
    @Override
    public BaseResponse save(SaveMenuRequest params, Integer dealUserId) {
        if (params.getParentMenuId() != 0) {
            if (!existMenuId(params.getParentMenuId())) {
                return BaseResponse.failMessage(MenuConstant.PARENT_MENU_ID_NOT_EXIST);
            }
        }
        if (params.getId() == null) {
            Menu menu = new Menu();
            BeanUtils.copyProperties(params, menu);
            menu.setCreateBy(dealUserId);
            menu.setCreateTime(new Date());
            customMenuMapper.insertSelective(menu);
            return BaseResponse.success();
        }
        Menu menu = customMenuMapper.selectByPrimaryKey(params.getId());
        if (menu == null) {
            return BaseResponse.failMessage(MenuConstant.MENU_ID_NOT_EXIST);
        }
        //判断是否有死循环  自己是自己的父节点
        if (existLoop(params.getId(), params.getParentMenuId())) {
            return BaseResponse.failMessage(MenuConstant.PARENT_MENU_ID_ERRO);
        }
        menu.setMenuName(params.getMenuName());
        menu.setParentMenuId(params.getParentMenuId());
        menu.setSort(params.getSort());
        menu.setUrl(params.getUrl());
        menu.setStatus(params.getStatus());
        menu.setUpdateBy(dealUserId);
        menu.setUpdateTime(new Date());
        customMenuMapper.updateByPrimaryKey(menu);
        return BaseResponse.success();
    }

    /**
     * @param ids
     * @param dealUserId
     * @return
     * @description 停用菜单
     * @author baixueping
     * @date 2019/6/20 10:44
     */
    @Override
    public BaseResponse delete(List<Integer> ids, Integer dealUserId) {
        if (CollectionUtils.isEmpty(ids)) {
            return BaseResponse.success();
        }
        MenuExample example = new MenuExample();
        example.createCriteria().andIdIn(ids);
        Menu menu = new Menu();
        menu.setStatus(MenuConstant.Status.DISABLED.getCode());
        menu.setUpdateBy(dealUserId);
        menu.setUpdateTime(new Date());
        customMenuMapper.updateByExampleSelective(menu, example);
        return BaseResponse.success();
    }

    /**
     * @return
     * @description 树菜单
     * @author baixueping
     * @date 2019/6/21 16:57
     */
    @Override
    public List<TreeResponse> tree() {
        TreeResponse treeResponse = new TreeResponse();
        treeResponse.setId(0);
        treeResponse.setText("菜单");
        List<Menu> menuList = getMenuAll();
        getTreeChildren(treeResponse, menuList);
        List<TreeResponse> list = new ArrayList<TreeResponse>();
        list.add(treeResponse);
        return list;
    }

    /**
     * @param currentUserId
     * @return
     * @description 获取当前用户菜单
     * @author baixueping
     * @date 2019/6/24 17:51
     */
    @Override
    public List<MenuTree> menuTree(Integer currentUserId) {
        //获取用户拥有的所有菜单
        List<Menu> menuIdList = customMenuMapper.userMenuIdList(currentUserId);
        MenuTree menuTree = new MenuTree();
        menuTree.setId(0);
        menuTree.setText("菜单");
        getMenuTreeChildren(menuTree, menuIdList);
        List<MenuTree> list = new ArrayList<>();
        list.add(menuTree);
        return list;
    }

    /**
     * @param userId
     * @param menu
     * @return
     * @description 判断用户是否有指定菜单权限
     * @author baixueping
     * @date 2019/8/7 10:35
     */
    @Override
    public boolean userHasMenu(Integer userId, String menu) {
        if (userId == null || StringUtils.isEmpty(menu)) {
            return false;
        }
        return customMenuMapper.userHasMenu(userId, menu);
    }

    /**
     * @param menuId@return
     * @description 获取菜单
     * @author baixueping
     * @date 2020/9/22 18:15
     */
    @Override
    public Menu selectById(Integer menuId) {
        if (menuId == null) {
            return null;
        }
        return customMenuMapper.selectByPrimaryKey(menuId);
    }

    /**
     * @return
     * @description 菜单权限树
     * @author baixueping
     * @date 2020/9/27 11:23
     */
    @Override
    public List<MenuRightTreeResponse> menuRightTree() {
        MenuRightTreeResponse menuRightTreeResponse = new MenuRightTreeResponse();
        menuRightTreeResponse.setId("0,0");
        menuRightTreeResponse.setText("菜单");
        menuRightTreeResponse.setMenuId(0);
        menuRightTreeResponse.setType(1);
        List<Menu> menuList = getMenuAll();
        List<Right> rightList = rightService.getRightAll();
        getMenuRightTreeChildren(menuRightTreeResponse, menuList, rightList);
        List<MenuRightTreeResponse> list = new ArrayList<MenuRightTreeResponse>();
        list.add(menuRightTreeResponse);
        return list;
    }

    @Override
    public List<String> userMenuUrlList(Integer userId) {
        if(userId==null){
            return new ArrayList<>();
        }
        return customMenuMapper.userMenuUrlList(userId);
    }

    private void getMenuRightTreeChildren(MenuRightTreeResponse menuRightTreeResponse, List<Menu> menuList, List<Right> rightList) {
        menuRightTreeResponse.setChildren(new ArrayList<MenuRightTreeResponse>());
        for (Menu menu :
                menuList) {
            if (menuRightTreeResponse.getMenuId().equals(menu.getParentMenuId())) {
                MenuRightTreeResponse menuRightTree = new MenuRightTreeResponse();
                menuRightTree.setId("menu," + menu.getId());
                menuRightTree.setMenuId(menu.getId());
                menuRightTree.setType(1);
                menuRightTree.setText(menu.getMenuName());
                //获取子菜单
                getMenuRightTreeChildren(menuRightTree, menuList, rightList);
                menuRightTreeResponse.getChildren().add(menuRightTree);
            }
        }
        //获取权限
        for (Right right : rightList) {
            if (right.getMenuId().equals(menuRightTreeResponse.getMenuId())) {
                MenuRightTreeResponse menuRight = new MenuRightTreeResponse();
                menuRight.setId("right," + right.getId());
                menuRight.setRightId(right.getId());
                menuRight.setType(2);
                menuRight.setText(right.getRightName());
                menuRight.setIconCls("icon-ok");
                menuRightTreeResponse.getChildren().add(menuRight);
            }
        }
    }

    private void getMenuTreeChildren(MenuTree menuTree, List<Menu> menuIdList) {
        if (CollectionUtils.isEmpty(menuIdList)) {
            return;
        }
        menuTree.setChildren(new ArrayList<MenuTree>());
        for (Menu menu : menuIdList) {
            if (menuTree.getId().equals(menu.getParentMenuId())) {
                MenuTree menuTreeChildren = new MenuTree();
                menuTreeChildren.setId(menu.getId());
                menuTreeChildren.setText(menu.getMenuName());
                if (!StringUtils.isEmpty(menu.getUrl())) {
                    MenuTreeAttributes attributes = new MenuTreeAttributes();
                    attributes.setUrl(menu.getUrl());
                    menuTreeChildren.setAttributes(attributes);
                }
                getMenuTreeChildren(menuTreeChildren, menuIdList);
                menuTree.getChildren().add(menuTreeChildren);
            }
        }
    }

    /**
     * @param
     * @param menuList
     * @return
     * @description 获取树
     * @author baixueping
     * @date 2019/6/24 9:08
     */
    private void getTreeChildren(TreeResponse treeResponse, List<Menu> menuList) {
        treeResponse.setChildren(new ArrayList<TreeResponse>());
        for (Menu menu :
                menuList) {
            if (treeResponse.getId().equals(menu.getParentMenuId())) {
                TreeResponse menuTree = new TreeResponse();
                menuTree.setId(menu.getId());
                menuTree.setText(menu.getMenuName());
                getTreeChildren(menuTree, menuList);
                treeResponse.getChildren().add(menuTree);
            }
        }
    }

    /**
     * @param
     * @return
     * @description 判断菜单是否存在循环
     * @author baixueping
     * @date 2019/6/25 9:25
     */
    private boolean existLoop(Integer menuId, Integer parentMenuId) {
        if (parentMenuId == 0) {
            return false;
        }
        if (menuId.equals(parentMenuId)) {
            return true;
        }
        while (parentMenuId != 0) {
            Menu parentMenu = customMenuMapper.selectByPrimaryKey(parentMenuId);
            if (parentMenu == null) {
                //数据错误
                return true;
            }
            parentMenuId = parentMenu.getParentMenuId();
            if (parentMenuId == 0) {
                return false;
            }
            if (menuId.equals(parentMenuId)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param
     * @return
     * @description 判断菜单id是否存在
     * @author baixueping
     * @date 2019/6/19 15:06
     */
    private boolean existMenuId(Integer id) {
        MenuExample example = new MenuExample();
        example.createCriteria().andIdEqualTo(id);
        long count = customMenuMapper.countByExample(example);
        if (count > 0) {
            return true;
        }
        return false;
    }

}
