package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.WorkOrder;
import com.sky.ddt.entity.WorkOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkOrderMapper {
    long countByExample(WorkOrderExample example);

    int deleteByExample(WorkOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WorkOrder record);

    int insertSelective(WorkOrder record);

    List<WorkOrder> selectByExampleWithBLOBs(WorkOrderExample example);

    List<WorkOrder> selectByExample(WorkOrderExample example);

    WorkOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WorkOrder record, @Param("example") WorkOrderExample example);

    int updateByExampleWithBLOBs(@Param("record") WorkOrder record, @Param("example") WorkOrderExample example);

    int updateByExample(@Param("record") WorkOrder record, @Param("example") WorkOrderExample example);

    int updateByPrimaryKeySelective(WorkOrder record);

    int updateByPrimaryKeyWithBLOBs(WorkOrder record);

    int updateByPrimaryKey(WorkOrder record);
}