package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.ShopUser;
import com.sky.ddt.entity.ShopUserExample;
import com.sky.ddt.entity.ShopUserKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopUserMapper {
    long countByExample(ShopUserExample example);

    int deleteByExample(ShopUserExample example);

    int deleteByPrimaryKey(ShopUserKey key);

    int insert(ShopUser record);

    int insertSelective(ShopUser record);

    List<ShopUser> selectByExample(ShopUserExample example);

    ShopUser selectByPrimaryKey(ShopUserKey key);

    int updateByExampleSelective(@Param("record") ShopUser record, @Param("example") ShopUserExample example);

    int updateByExample(@Param("record") ShopUser record, @Param("example") ShopUserExample example);

    int updateByPrimaryKeySelective(ShopUser record);

    int updateByPrimaryKey(ShopUser record);
}