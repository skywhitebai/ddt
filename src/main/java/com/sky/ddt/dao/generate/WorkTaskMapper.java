package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.WorkTask;
import com.sky.ddt.entity.WorkTaskExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkTaskMapper {
    long countByExample(WorkTaskExample example);

    int deleteByExample(WorkTaskExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WorkTask record);

    int insertSelective(WorkTask record);

    List<WorkTask> selectByExampleWithBLOBs(WorkTaskExample example);

    List<WorkTask> selectByExample(WorkTaskExample example);

    WorkTask selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WorkTask record, @Param("example") WorkTaskExample example);

    int updateByExampleWithBLOBs(@Param("record") WorkTask record, @Param("example") WorkTaskExample example);

    int updateByExample(@Param("record") WorkTask record, @Param("example") WorkTaskExample example);

    int updateByPrimaryKeySelective(WorkTask record);

    int updateByPrimaryKeyWithBLOBs(WorkTask record);

    int updateByPrimaryKey(WorkTask record);
}