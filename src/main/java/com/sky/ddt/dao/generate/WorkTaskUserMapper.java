package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.WorkTaskUser;
import com.sky.ddt.entity.WorkTaskUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkTaskUserMapper {
    long countByExample(WorkTaskUserExample example);

    int deleteByExample(WorkTaskUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WorkTaskUser record);

    int insertSelective(WorkTaskUser record);

    List<WorkTaskUser> selectByExample(WorkTaskUserExample example);

    WorkTaskUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WorkTaskUser record, @Param("example") WorkTaskUserExample example);

    int updateByExample(@Param("record") WorkTaskUser record, @Param("example") WorkTaskUserExample example);

    int updateByPrimaryKeySelective(WorkTaskUser record);

    int updateByPrimaryKey(WorkTaskUser record);
}