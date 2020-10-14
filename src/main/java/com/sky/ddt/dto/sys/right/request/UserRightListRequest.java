package com.sky.ddt.dto.sys.right.request;

import lombok.Data;

import java.util.List;

/**
 * @author baixueping
 * @description 用户权限列表
 * @date 2020/9/27 16:07
 */
@Data
public class UserRightListRequest {
    List<String> rightStrList;
    Integer userId;
}
