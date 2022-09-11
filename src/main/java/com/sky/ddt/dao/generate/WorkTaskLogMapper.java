package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.WorkTaskLog;
import com.sky.ddt.entity.WorkTaskLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkTaskLogMapper {
    long countByExample(WorkTaskLogExample example);

    int deleteByExample(WorkTaskLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WorkTaskLog record);

    int insertSelective(WorkTaskLog record);

    List<WorkTaskLog> selectByExampleWithBLOBs(WorkTaskLogExample example);

    List<WorkTaskLog> selectByExample(WorkTaskLogExample example);

    WorkTaskLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WorkTaskLog record, @Param("example") WorkTaskLogExample example);

    int updateByExampleWithBLOBs(@Param("record") WorkTaskLog record, @Param("example") WorkTaskLogExample example);

    int updateByExample(@Param("record") WorkTaskLog record, @Param("example") WorkTaskLogExample example);

    int updateByPrimaryKeySelective(WorkTaskLog record);

    int updateByPrimaryKeyWithBLOBs(WorkTaskLog record);

    int updateByPrimaryKey(WorkTaskLog record);
}