package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.WorkTaskCreationRole;
import com.sky.ddt.entity.WorkTaskCreationRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkTaskCreationRoleMapper {
    long countByExample(WorkTaskCreationRoleExample example);

    int deleteByExample(WorkTaskCreationRoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WorkTaskCreationRole record);

    int insertSelective(WorkTaskCreationRole record);

    List<WorkTaskCreationRole> selectByExample(WorkTaskCreationRoleExample example);

    WorkTaskCreationRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WorkTaskCreationRole record, @Param("example") WorkTaskCreationRoleExample example);

    int updateByExample(@Param("record") WorkTaskCreationRole record, @Param("example") WorkTaskCreationRoleExample example);

    int updateByPrimaryKeySelective(WorkTaskCreationRole record);

    int updateByPrimaryKey(WorkTaskCreationRole record);
}