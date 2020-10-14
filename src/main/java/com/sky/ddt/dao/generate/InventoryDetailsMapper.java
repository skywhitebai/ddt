package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.InventoryDetails;
import com.sky.ddt.entity.InventoryDetailsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InventoryDetailsMapper {
    long countByExample(InventoryDetailsExample example);

    int deleteByExample(InventoryDetailsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(InventoryDetails record);

    int insertSelective(InventoryDetails record);

    List<InventoryDetails> selectByExample(InventoryDetailsExample example);

    InventoryDetails selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") InventoryDetails record, @Param("example") InventoryDetailsExample example);

    int updateByExample(@Param("record") InventoryDetails record, @Param("example") InventoryDetailsExample example);

    int updateByPrimaryKeySelective(InventoryDetails record);

    int updateByPrimaryKey(InventoryDetails record);
}