package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.user.request.UserListRequest;
import com.sky.ddt.dto.user.request.UserSaveRequest;
import com.sky.ddt.dto.user.response.UserComboboxResponse;
import com.sky.ddt.dto.user.response.UserListResponse;
import com.sky.ddt.entity.User;

import java.util.List;

public interface IUserService {
    PageInfo<UserListResponse> list(UserListRequest params);

    /**
     * @param params
     * @param dealUserId
     * @return
     */
    BaseResponse save(UserSaveRequest params, Integer dealUserId);

    BaseResponse delete(List<Integer> userIds, Integer dealUserId);

    /**
     * 通过loginToken获取用户
     *
     * @param loginToken
     * @return
     */
    User getUserByLoginToken(String loginToken);

    /**
     * @param
     * @return
     * @description 用户下拉
     * @author baixueping
     * @date 2019/7/19 15:04
     */
    List<UserComboboxResponse> comboboxlist();

    /**
     * @param
     * @return
     * @description 判断用户id是否存在
     * @author baixueping
     * @date 2019/7/19 15:25
     */
    boolean exist(Integer userId);

    /**
     * @param
     * @return
     * @description 根据用户名获取用户信息
     * @author baixueping
     * @date 2020/1/3 10:21
     */
    User getUserByUserName(String userName);
}
