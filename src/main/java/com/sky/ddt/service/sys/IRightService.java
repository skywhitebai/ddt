package com.sky.ddt.service.sys;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.sys.right.request.ListRightRequest;
import com.sky.ddt.dto.sys.right.request.SaveRightRequest;
import com.sky.ddt.dto.sys.right.request.UserRightListRequest;
import com.sky.ddt.entity.Right;

import java.util.List;

/**
 * @author baixueping
 * @description 权限服务
 * @date 2020/9/22 16:36
 */
public interface IRightService {
    /**
     * @param
     * @return
     * @description 列表查询权限
     * @author baixueping
     * @date 2020/9/22 17:47
     */
    PageInfo<Right> listRight(ListRightRequest params);

    /**
     * @param
     * @return
     * @description 保存权限
     * @author baixueping
     * @date 2020/9/22 18:12
     */
    BaseResponse saveRight(SaveRightRequest params, Integer dealUserId);

    /**
     * @param
     * @param id
     * @return
     * @description 删除权限
     * @author baixueping
     * @date 2020/9/22 18:38
     */
    BaseResponse deleteRight(List<Integer> id);

    /**
     * @param
     * @return
     * @description 获取全部权限
     * @author baixueping
     * @date 2020/9/27 11:34
     */
    List<Right> getRightAll();

    /**
     * @param
     * @return
     * @description 判断用户是否有权限
     * @author baixueping
     * @date 2020/9/27 15:51
     */
    boolean userHasRight(Integer userId, String right);

    /**
     * @param
     * @return
     * @description 用户权限列表
     * @author baixueping
     * @date 2020/9/27 16:10
     */
    BaseResponse userRightList(UserRightListRequest params);
}
