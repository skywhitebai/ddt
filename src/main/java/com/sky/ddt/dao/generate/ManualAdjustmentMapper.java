package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.ManualAdjustment;
import com.sky.ddt.entity.ManualAdjustmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ManualAdjustmentMapper {
    long countByExample(ManualAdjustmentExample example);

    int deleteByExample(ManualAdjustmentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ManualAdjustment record);

    int insertSelective(ManualAdjustment record);

    List<ManualAdjustment> selectByExample(ManualAdjustmentExample example);

    ManualAdjustment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ManualAdjustment record, @Param("example") ManualAdjustmentExample example);

    int updateByExample(@Param("record") ManualAdjustment record, @Param("example") ManualAdjustmentExample example);

    int updateByPrimaryKeySelective(ManualAdjustment record);

    int updateByPrimaryKey(ManualAdjustment record);
}