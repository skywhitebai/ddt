package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.UserMapper;
import com.sky.ddt.dto.user.request.UserListRequest;
import com.sky.ddt.dto.user.response.UserComboboxResponse;
import com.sky.ddt.dto.user.response.UserListResponse;

import java.util.List;

public interface CustomUserMapper extends UserMapper {
    /**
     * @param
     * @return
     * @description 用户下拉
     * @author baixueping
     * @date 2019/7/19 15:05
     */
    List<UserComboboxResponse> comboboxlist();

    /**
     * @param
     * @return
     * @description 分页查询列表数据
     * @author baixueping
     * @date 2019/8/20 8:55
     */
    List<UserListResponse> listUser(UserListRequest params);
}
