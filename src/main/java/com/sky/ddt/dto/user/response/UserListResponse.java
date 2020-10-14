package com.sky.ddt.dto.user.response;

import com.sky.ddt.entity.User;
import lombok.Data;

/**
 * @author baixueping
 * @description 用户列表返回值
 * @date 2019/8/20 8:53
 */
@Data
public class UserListResponse extends User {
    String roleNames;
}
