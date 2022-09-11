package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.WorkTaskCreation;
import com.sky.ddt.entity.WorkTaskCreationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkTaskCreationMapper {
    long countByExample(WorkTaskCreationExample example);

    int deleteByExample(WorkTaskCreationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WorkTaskCreation record);

    int insertSelective(WorkTaskCreation record);

    List<WorkTaskCreation> selectByExampleWithBLOBs(WorkTaskCreationExample example);

    List<WorkTaskCreation> selectByExample(WorkTaskCreationExample example);

    WorkTaskCreation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WorkTaskCreation record, @Param("example") WorkTaskCreationExample example);

    int updateByExampleWithBLOBs(@Param("record") WorkTaskCreation record, @Param("example") WorkTaskCreationExample example);

    int updateByExample(@Param("record") WorkTaskCreation record, @Param("example") WorkTaskCreationExample example);

    int updateByPrimaryKeySelective(WorkTaskCreation record);

    int updateByPrimaryKeyWithBLOBs(WorkTaskCreation record);

    int updateByPrimaryKey(WorkTaskCreation record);
}