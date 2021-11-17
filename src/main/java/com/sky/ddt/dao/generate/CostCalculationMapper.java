package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.CostCalculation;
import com.sky.ddt.entity.CostCalculationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CostCalculationMapper {
    long countByExample(CostCalculationExample example);

    int deleteByExample(CostCalculationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CostCalculation record);

    int insertSelective(CostCalculation record);

    List<CostCalculation> selectByExample(CostCalculationExample example);

    CostCalculation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CostCalculation record, @Param("example") CostCalculationExample example);

    int updateByExample(@Param("record") CostCalculation record, @Param("example") CostCalculationExample example);

    int updateByPrimaryKeySelective(CostCalculation record);

    int updateByPrimaryKey(CostCalculation record);
}