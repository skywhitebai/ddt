package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.CostCalculationSku;
import com.sky.ddt.entity.CostCalculationSkuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CostCalculationSkuMapper {
    long countByExample(CostCalculationSkuExample example);

    int deleteByExample(CostCalculationSkuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CostCalculationSku record);

    int insertSelective(CostCalculationSku record);

    List<CostCalculationSku> selectByExample(CostCalculationSkuExample example);

    CostCalculationSku selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CostCalculationSku record, @Param("example") CostCalculationSkuExample example);

    int updateByExample(@Param("record") CostCalculationSku record, @Param("example") CostCalculationSkuExample example);

    int updateByPrimaryKeySelective(CostCalculationSku record);

    int updateByPrimaryKey(CostCalculationSku record);
}