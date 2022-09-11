package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.WorkTask;
import com.sky.ddt.entity.WorkTaskExample;
import com.sky.ddt.entity.WorkTaskWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkTaskMapper {
    long countByExample(WorkTaskExample example);

    int deleteByExample(WorkTaskExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WorkTaskWithBLOBs record);

    int insertSelective(WorkTaskWithBLOBs record);

    List<WorkTaskWithBLOBs> selectByExampleWithBLOBs(WorkTaskExample example);

    List<WorkTask> selectByExample(WorkTaskExample example);

    WorkTaskWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WorkTaskWithBLOBs record, @Param("example") WorkTaskExample example);

    int updateByExampleWithBLOBs(@Param("record") WorkTaskWithBLOBs record, @Param("example") WorkTaskExample example);

    int updateByExample(@Param("record") WorkTask record, @Param("example") WorkTaskExample example);

    int updateByPrimaryKeySelective(WorkTaskWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(WorkTaskWithBLOBs record);

    int updateByPrimaryKey(WorkTask record);
}