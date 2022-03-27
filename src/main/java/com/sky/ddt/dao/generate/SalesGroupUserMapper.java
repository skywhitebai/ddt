package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.SalesGroupUser;
import com.sky.ddt.entity.SalesGroupUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SalesGroupUserMapper {
    long countByExample(SalesGroupUserExample example);

    int deleteByExample(SalesGroupUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SalesGroupUser record);

    int insertSelective(SalesGroupUser record);

    List<SalesGroupUser> selectByExample(SalesGroupUserExample example);

    SalesGroupUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SalesGroupUser record, @Param("example") SalesGroupUserExample example);

    int updateByExample(@Param("record") SalesGroupUser record, @Param("example") SalesGroupUserExample example);

    int updateByPrimaryKeySelective(SalesGroupUser record);

    int updateByPrimaryKey(SalesGroupUser record);
}