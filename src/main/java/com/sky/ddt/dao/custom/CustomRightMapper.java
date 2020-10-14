package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.RightMapper;
import com.sky.ddt.dto.sys.right.request.UserRightListRequest;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author baixueping
 * @description 权限操作类
 * @date 2020/9/22 16:35
 */
@Service
public interface CustomRightMapper extends RightMapper {
    boolean userHasRight(@Param("userId")Integer userId, @Param("right") String right);

    List<String> userRightList(UserRightListRequest params);
}
