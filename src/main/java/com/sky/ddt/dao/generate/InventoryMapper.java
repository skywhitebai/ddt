package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.Inventory;
import com.sky.ddt.entity.InventoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InventoryMapper {
    long countByExample(InventoryExample example);

    int deleteByExample(InventoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Inventory record);

    int insertSelective(Inventory record);

    List<Inventory> selectByExample(InventoryExample example);

    Inventory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Inventory record, @Param("example") InventoryExample example);

    int updateByExample(@Param("record") Inventory record, @Param("example") InventoryExample example);

    int updateByPrimaryKeySelective(Inventory record);

    int updateByPrimaryKey(Inventory record);
}