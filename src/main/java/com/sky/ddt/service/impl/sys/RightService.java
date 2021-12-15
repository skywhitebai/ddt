package com.sky.ddt.service.impl.sys;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sky.ddt.common.constant.RightConstant;
import com.sky.ddt.dao.custom.CustomRightMapper;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.sys.right.request.ListRightRequest;
import com.sky.ddt.dto.sys.right.request.SaveRightRequest;
import com.sky.ddt.dto.sys.right.request.UserRightListRequest;
import com.sky.ddt.entity.Menu;
import com.sky.ddt.entity.Right;
import com.sky.ddt.entity.RightExample;
import com.sky.ddt.service.sys.IMenuService;
import com.sky.ddt.service.sys.IRightService;
import com.sky.ddt.service.sys.IRoleRightService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * @author baixueping
 * @description 权限服务
 * @date 2020/9/22 16:36
 */
@Service
public class RightService implements IRightService {
    @Autowired
    CustomRightMapper customRightMapper;
    @Autowired
    IMenuService menuService;
    @Autowired
    IRoleRightService roleRightService;

    /**
     * @param params @return
     * @description 列表查询权限
     * @author baixueping
     * @date 2020/9/22 17:47
     */
    @Override
    public PageInfo<Right> listRight(ListRightRequest params) {
        PageHelper.startPage(params.getPage(), params.getRows(), true);
        RightExample example = new RightExample();
        RightExample.Criteria criteria = example.createCriteria();
        if (params.getMenuId() != null) {
            criteria.andMenuIdEqualTo(params.getMenuId());
        }
        if (!StringUtils.isEmpty(params.getRightName())) {
            criteria.andRightNameLike("%"+params.getRightName()+"%");
        }
        if (!StringUtils.isEmpty(params.getRightStr())) {
            criteria.andRightStrLike("%"+params.getRightStr()+"%");
        }
        example.setOrderByClause("update_time desc");
        List<Right> list = customRightMapper.selectByExample(example);
        PageInfo<Right> page = new PageInfo<Right>(list);
        return page;
    }

    /**
     * @param params
     * @param dealUserId
     * @return
     * @description 保存权限
     * @author baixueping
     * @date 2020/9/22 18:12
     */
    @Override
    public BaseResponse saveRight(SaveRightRequest params, Integer dealUserId) {
        Menu menu = menuService.selectById(params.getMenuId());
        if (menu == null) {
            return BaseResponse.failMessage(RightConstant.MENU_ID_NOT_EXIST);
        }
        if (existRightName(params.getId(), params.getRightName())) {
            return BaseResponse.failMessage(RightConstant.RIGHT_NAME_EXIST);
        }
        if (existRightStr(params.getId(), params.getRightStr())) {
            return BaseResponse.failMessage(RightConstant.RIGHT_STR_EXIST);
        }
        Right sysRight = new Right();
        BeanUtils.copyProperties(params, sysRight);
        if (params.getId() == null) {
            sysRight.setCreateBy(dealUserId);
            sysRight.setCreateTime(new Date());
            customRightMapper.insertSelective(sysRight);
        } else {
            sysRight.setUpdateBy(dealUserId);
            sysRight.setUpdateTime(new Date());
            customRightMapper.updateByPrimaryKeySelective(sysRight);
        }
        return BaseResponse.success();
    }

    /**
     * @param rightIds @return
     * @description 删除权限
     * @author baixueping
     * @date 2020/9/22 18:38
     */
    @Override
    public BaseResponse deleteRight(List<Integer> rightIds) {
        if (CollectionUtils.isEmpty(rightIds) ) {
            return BaseResponse.failMessage(RightConstant.ID_EMPTY);
        }
        for (Integer id:
                rightIds) {
            // 删除角色权限关系
            roleRightService.deleteByRightId(id);
            //删除权限
            customRightMapper.deleteByPrimaryKey(id);
        }
        return BaseResponse.success();
    }

    /**
     * @return
     * @description 获取全部权限
     * @author baixueping
     * @date 2020/9/27 11:34
     */
    @Override
    public List<Right> getRightAll() {
        return customRightMapper.selectByExample(null);
    }

    /**
     * @param userId
     * @param right
     * @return
     * @description 判断用户是否有权限
     * @author baixueping
     * @date 2020/9/27 15:51
     */
    @Override
    public boolean userHasRight(Integer userId, String right) {
        if(userId==null||StringUtils.isEmpty(right)){
            return false;
        }
        return customRightMapper.userHasRight(userId,right);
    }

    /**
     * @param params@return
     * @description 用户权限列表
     * @author baixueping
     * @date 2020/9/27 16:10
     */
    @Override
    public BaseResponse userRightList(UserRightListRequest params) {
        List<String> list=customRightMapper.userRightList(params);
        return BaseResponse.successData(list);
    }

    private boolean existRightStr(Integer id, String rightStr) {
        RightExample example = new RightExample();
        RightExample.Criteria ct = example.createCriteria();
        if (id != null) {
            ct.andIdNotEqualTo(id);
        }
        ct.andRightStrEqualTo(rightStr);
        return customRightMapper.countByExample(example) > 0;
    }

    private boolean existRightName(Integer id, String rightName) {
        RightExample example = new RightExample();
        RightExample.Criteria ct = example.createCriteria();
        if (id != null) {
            ct.andIdNotEqualTo(id);
        }
        ct.andRightNameEqualTo(rightName);
        return customRightMapper.countByExample(example) > 0;
    }
}
