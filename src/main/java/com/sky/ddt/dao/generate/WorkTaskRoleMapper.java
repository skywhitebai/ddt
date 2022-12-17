package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.WorkTaskRole;
import com.sky.ddt.entity.WorkTaskRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkTaskRoleMapper {
    long countByExample(WorkTaskRoleExample example);

    int deleteByExample(WorkTaskRoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WorkTaskRole record);

    int insertSelective(WorkTaskRole record);

    List<WorkTaskRole> selectByExample(WorkTaskRoleExample example);

    WorkTaskRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WorkTaskRole record, @Param("example") WorkTaskRoleExample example);

    int updateByExample(@Param("record") WorkTaskRole record, @Param("example") WorkTaskRoleExample example);

    int updateByPrimaryKeySelective(WorkTaskRole record);

    int updateByPrimaryKey(WorkTaskRole record);
}