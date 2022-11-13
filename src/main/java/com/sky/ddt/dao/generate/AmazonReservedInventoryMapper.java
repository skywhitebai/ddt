package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.AmazonReservedInventory;
import com.sky.ddt.entity.AmazonReservedInventoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AmazonReservedInventoryMapper {
    long countByExample(AmazonReservedInventoryExample example);

    int deleteByExample(AmazonReservedInventoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AmazonReservedInventory record);

    int insertSelective(AmazonReservedInventory record);

    List<AmazonReservedInventory> selectByExample(AmazonReservedInventoryExample example);

    AmazonReservedInventory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AmazonReservedInventory record, @Param("example") AmazonReservedInventoryExample example);

    int updateByExample(@Param("record") AmazonReservedInventory record, @Param("example") AmazonReservedInventoryExample example);

    int updateByPrimaryKeySelective(AmazonReservedInventory record);

    int updateByPrimaryKey(AmazonReservedInventory record);
}