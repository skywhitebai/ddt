package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.DisplayAdvertising;
import com.sky.ddt.entity.DisplayAdvertisingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DisplayAdvertisingMapper {
    long countByExample(DisplayAdvertisingExample example);

    int deleteByExample(DisplayAdvertisingExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DisplayAdvertising record);

    int insertSelective(DisplayAdvertising record);

    List<DisplayAdvertising> selectByExample(DisplayAdvertisingExample example);

    DisplayAdvertising selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DisplayAdvertising record, @Param("example") DisplayAdvertisingExample example);

    int updateByExample(@Param("record") DisplayAdvertising record, @Param("example") DisplayAdvertisingExample example);

    int updateByPrimaryKeySelective(DisplayAdvertising record);

    int updateByPrimaryKey(DisplayAdvertising record);
}