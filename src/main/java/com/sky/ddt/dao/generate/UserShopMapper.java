package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.UserShop;
import com.sky.ddt.entity.UserShopExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserShopMapper {
    long countByExample(UserShopExample example);

    int deleteByExample(UserShopExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserShop record);

    int insertSelective(UserShop record);

    List<UserShop> selectByExample(UserShopExample example);

    UserShop selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserShop record, @Param("example") UserShopExample example);

    int updateByExample(@Param("record") UserShop record, @Param("example") UserShopExample example);

    int updateByPrimaryKeySelective(UserShop record);

    int updateByPrimaryKey(UserShop record);
}