package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.LightingDeal;
import com.sky.ddt.entity.LightingDealExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LightingDealMapper {
    long countByExample(LightingDealExample example);

    int deleteByExample(LightingDealExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LightingDeal record);

    int insertSelective(LightingDeal record);

    List<LightingDeal> selectByExample(LightingDealExample example);

    LightingDeal selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LightingDeal record, @Param("example") LightingDealExample example);

    int updateByExample(@Param("record") LightingDeal record, @Param("example") LightingDealExample example);

    int updateByPrimaryKeySelective(LightingDeal record);

    int updateByPrimaryKey(LightingDeal record);
}