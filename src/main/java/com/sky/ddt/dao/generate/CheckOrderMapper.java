package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.CheckOrder;
import com.sky.ddt.entity.CheckOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CheckOrderMapper {
    long countByExample(CheckOrderExample example);

    int deleteByExample(CheckOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CheckOrder record);

    int insertSelective(CheckOrder record);

    List<CheckOrder> selectByExample(CheckOrderExample example);

    CheckOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CheckOrder record, @Param("example") CheckOrderExample example);

    int updateByExample(@Param("record") CheckOrder record, @Param("example") CheckOrderExample example);

    int updateByPrimaryKeySelective(CheckOrder record);

    int updateByPrimaryKey(CheckOrder record);
}