package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.ShopSenderAddress;
import com.sky.ddt.entity.ShopSenderAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopSenderAddressMapper {
    long countByExample(ShopSenderAddressExample example);

    int deleteByExample(ShopSenderAddressExample example);

    int deleteByPrimaryKey(Integer shopId);

    int insert(ShopSenderAddress record);

    int insertSelective(ShopSenderAddress record);

    List<ShopSenderAddress> selectByExample(ShopSenderAddressExample example);

    ShopSenderAddress selectByPrimaryKey(Integer shopId);

    int updateByExampleSelective(@Param("record") ShopSenderAddress record, @Param("example") ShopSenderAddressExample example);

    int updateByExample(@Param("record") ShopSenderAddress record, @Param("example") ShopSenderAddressExample example);

    int updateByPrimaryKeySelective(ShopSenderAddress record);

    int updateByPrimaryKey(ShopSenderAddress record);
}