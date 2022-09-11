package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.WorkTaskCreationUser;
import com.sky.ddt.entity.WorkTaskCreationUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkTaskCreationUserMapper {
    long countByExample(WorkTaskCreationUserExample example);

    int deleteByExample(WorkTaskCreationUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WorkTaskCreationUser record);

    int insertSelective(WorkTaskCreationUser record);

    List<WorkTaskCreationUser> selectByExample(WorkTaskCreationUserExample example);

    WorkTaskCreationUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WorkTaskCreationUser record, @Param("example") WorkTaskCreationUserExample example);

    int updateByExample(@Param("record") WorkTaskCreationUser record, @Param("example") WorkTaskCreationUserExample example);

    int updateByPrimaryKeySelective(WorkTaskCreationUser record);

    int updateByPrimaryKey(WorkTaskCreationUser record);
}