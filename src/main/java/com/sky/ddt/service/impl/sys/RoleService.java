package com.sky.ddt.service.impl.sys;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.constant.RoleConstant;
import com.sky.ddt.dao.custom.CustomRoleMapper;
import com.sky.ddt.dto.easyui.request.DataGridRequest;
import com.sky.ddt.dto.easyui.response.TreeResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.sys.role.request.RoleSaveRequest;
import com.sky.ddt.entity.Role;
import com.sky.ddt.entity.RoleExample;
import com.sky.ddt.entity.User;
import com.sky.ddt.service.sys.IRoleMenuService;
import com.sky.ddt.service.sys.IRoleService;
import com.sky.ddt.service.sys.IUserRoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author baixueping
 * @description 角色服务
 * @date 2019/6/13 15:48
 */
@Service
public class RoleService implements IRoleService {
    @Autowired
    CustomRoleMapper customRoleMapper;
    @Autowired
    IUserRoleService userRoleService;
    @Autowired
    IRoleMenuService roleMenuService;

    @Override
    public List<Role> comboboxlist() {
        return customRoleMapper.comboboxlist();
    }

    /**
     * @param params@return
     * @description 角色列表
     * @author baixueping
     * @date 2019/6/21 9:35
     */
    @Override
    public PageInfo<Role> list(DataGridRequest params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        RoleExample example = new RoleExample();
        example.setOrderByClause(" create_time desc");
        List<Role> list = customRoleMapper.selectByExample(example);
        PageInfo<Role> page = new PageInfo<Role>(list);
        return page;
    }

    /**
     * @param params     @return
     * @param dealUserId
     * @description 保存角色
     * @author baixueping
     * @date 2019/6/21 10:20
     */
    @Override
    public BaseResponse save(RoleSaveRequest params, Integer dealUserId) {
        if (existRepeatRoleName(params.getId(), params.getRoleName())) {
            return BaseResponse.failMessage(RoleConstant.EXIST_REPEAT_ROLE_NAME);
        }
        if (params.getId() != null) {
            Role roleOld = customRoleMapper.selectByPrimaryKey(params.getId());
            if (roleOld == null) {
                return BaseResponse.failMessage(RoleConstant.ID_NOT_EXIST);
            }
            roleOld.setRemark(params.getRemark());
            roleOld.setRoleName(params.getRoleName());
            roleOld.setUpdateBy(dealUserId);
            roleOld.setUpdateTime(new Date());
            customRoleMapper.updateByPrimaryKey(roleOld);
            return BaseResponse.success();
        }
        Role role = new Role();
        BeanUtils.copyProperties(params, role);
        role.setCreateBy(dealUserId);
        role.setCreateTime(new Date());
        customRoleMapper.insertSelective(role);
        return BaseResponse.success();
    }

    /**
     * @param id@return
     * @description 删除角色
     * @author baixueping
     * @date 2019/6/21 11:08
     */
    @Override
    public BaseResponse delete(Integer id) {
        userRoleService.deleteByRoleId(id);
        roleMenuService.deleteByRoleId(id);
        customRoleMapper.deleteByPrimaryKey(id);
        return BaseResponse.success();
    }

    @Override
    public List<TreeResponse> tree() {
        TreeResponse treeResponse = new TreeResponse();
        treeResponse.setId(0);
        treeResponse.setText("角色");
        List<Role> roleList = getRoleList();
        getTreeChildren(treeResponse, roleList);
        List<TreeResponse> list = new ArrayList<TreeResponse>();
        list.add(treeResponse);
        return list;
    }

    private void getTreeChildren(TreeResponse treeResponse, List<Role> roleList) {
        treeResponse.setChildren(new ArrayList<TreeResponse>());
        for (Role role :
                roleList) {
            TreeResponse userTree = new TreeResponse();
            userTree.setId(role.getId());
            userTree.setText(role.getRoleName());
            treeResponse.getChildren().add(userTree);
        }
    }

    private List<Role> getRoleList() {
        RoleExample roleExample=new RoleExample();
        return customRoleMapper.selectByExample(roleExample);
    }

    private boolean existRepeatRoleName(Integer id, String roleName) {
        RoleExample example = new RoleExample();
        if (id == null) {
            example.createCriteria().andRoleNameEqualTo(roleName);
        } else {
            example.createCriteria().andRoleNameEqualTo(roleName).andIdNotEqualTo(id);
        }
        long count = customRoleMapper.countByExample(example);
        return count > 0;
    }
}
