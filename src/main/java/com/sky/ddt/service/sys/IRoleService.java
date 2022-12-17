package com.sky.ddt.service.sys;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.easyui.request.DataGridRequest;
import com.sky.ddt.dto.easyui.response.TreeResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.sys.role.request.RoleSaveRequest;
import com.sky.ddt.entity.Role;

import java.util.List;

/**
 * @author baixueping
 * @description 角色服务类
 * @date 2019/6/13 15:47
 */
public interface IRoleService {
    /**
     * @param
     * @return
     * @description 角色下拉数据
     * @author baixueping
     * @date 2019/6/21 9:36
     */
    List<Role> comboboxlist();

    /**
     * @param
     * @return
     * @description 角色列表
     * @author baixueping
     * @date 2019/6/21 9:35
     */
    PageInfo<Role> list(DataGridRequest params);

    /**
     * @param
     * @param dealUserId
     * @return
     * @description 保存角色
     * @author baixueping
     * @date 2019/6/21 10:20
     */
    BaseResponse save(RoleSaveRequest params, Integer dealUserId);

    /**
     * @param
     * @return
     * @description 删除角色
     * @author baixueping
     * @date 2019/6/21 11:08
     */
    BaseResponse delete(Integer id);

    List<TreeResponse> tree();
}
