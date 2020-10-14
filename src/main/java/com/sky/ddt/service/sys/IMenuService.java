package com.sky.ddt.service.sys;

import com.sky.ddt.dto.easyui.response.MenuRightTreeResponse;
import com.sky.ddt.dto.easyui.response.MenuTree;
import com.sky.ddt.dto.easyui.response.TreeResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.sys.menu.request.SaveMenuRequest;
import com.sky.ddt.dto.sys.menu.response.MenuTreeResponse;
import com.sky.ddt.entity.Menu;

import java.util.List;

/**
 * @author baixueping
 * @description 菜单服务类
 * @date 2019/6/12 15:10
 */

public interface IMenuService {
    /**
     * @param
     * @return
     * @description 获取菜单列表
     * @author baixueping
     * @date 2019/6/18 17:45
     */
    MenuTreeResponse treegrid();

    /**
     * @param
     * @return
     * @description 保存菜单
     * @author baixueping
     * @date 2019/6/19 14:49
     */
    BaseResponse save(SaveMenuRequest params, Integer dealUserId);

    /**
     * @param
     * @return
     * @description 停用菜单
     * @author baixueping
     * @date 2019/6/20 10:44
     */
    BaseResponse delete(List<Integer> ids, Integer dealUserId);

    /**
     * @param
     * @return
     * @description 树菜单
     * @author baixueping
     * @date 2019/6/21 16:57
     */
    List<TreeResponse> tree();

    /**
     * @param
     * @return
     * @description 获取当前用户菜单
     * @author baixueping
     * @date 2019/6/24 17:51
     */
    List<MenuTree> menuTree(Integer currentUserId);

    /**
     * @param
     * @return
     * @description 判断用户是否有指定菜单权限
     * @author baixueping
     * @date 2019/8/7 10:35
     */
    boolean userHasMenu(Integer userId, String menu);

    /**
     * @param
     * @return
     * @description 获取菜单
     * @author baixueping
     * @date 2020/9/22 18:15
     */
    Menu selectById(Integer menuId);

    /**
     * @param
     * @return
     * @description 菜单权限树
     * @author baixueping
     * @date 2020/9/27 11:23
     */
    List<MenuRightTreeResponse> menuRightTree();

    List<String> userMenuUrlList(Integer userId);
}
