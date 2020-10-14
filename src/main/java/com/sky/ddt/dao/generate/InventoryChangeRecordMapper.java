package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.InventoryChangeRecord;
import com.sky.ddt.entity.InventoryChangeRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InventoryChangeRecordMapper {
    long countByExample(InventoryChangeRecordExample example);

    int deleteByExample(InventoryChangeRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(InventoryChangeRecord record);

    int insertSelective(InventoryChangeRecord record);

    List<InventoryChangeRecord> selectByExample(InventoryChangeRecordExample example);

    InventoryChangeRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") InventoryChangeRecord record, @Param("example") InventoryChangeRecordExample example);

    int updateByExample(@Param("record") InventoryChangeRecord record, @Param("example") InventoryChangeRecordExample example);

    int updateByPrimaryKeySelective(InventoryChangeRecord record);

    int updateByPrimaryKey(InventoryChangeRecord record);
}