package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.SalesGroup;
import com.sky.ddt.entity.SalesGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SalesGroupMapper {
    long countByExample(SalesGroupExample example);

    int deleteByExample(SalesGroupExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SalesGroup record);

    int insertSelective(SalesGroup record);

    List<SalesGroup> selectByExample(SalesGroupExample example);

    SalesGroup selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SalesGroup record, @Param("example") SalesGroupExample example);

    int updateByExample(@Param("record") SalesGroup record, @Param("example") SalesGroupExample example);

    int updateByPrimaryKeySelective(SalesGroup record);

    int updateByPrimaryKey(SalesGroup record);
}