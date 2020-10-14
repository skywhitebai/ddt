package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.MenuMapper;
import com.sky.ddt.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author baixueping
 * @description 菜单管理
 * @date 2019/6/18 17:49
 */
public interface CustomMenuMapper extends MenuMapper {
    /**
     * @param
     * @return
     * @description 用户拥有的菜单id
     * @author baixueping
     * @date 2019/6/24 18:01
     */
    List<Menu> userMenuIdList(Integer userId);

    /**
     * @param userId
     * @param menu
     * @return
     * @description 判断用户是否有指定菜单权限
     * @author baixueping
     * @date 2019/8/7 10:35
     */
    boolean userHasMenu(@Param("userId")Integer userId,@Param("menu") String menu);

    List<String> userMenuUrlList(Integer userId);
}
