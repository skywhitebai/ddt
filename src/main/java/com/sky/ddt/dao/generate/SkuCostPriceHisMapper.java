package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.SkuCostPriceHis;
import com.sky.ddt.entity.SkuCostPriceHisExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SkuCostPriceHisMapper {
    long countByExample(SkuCostPriceHisExample example);

    int deleteByExample(SkuCostPriceHisExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SkuCostPriceHis record);

    int insertSelective(SkuCostPriceHis record);

    List<SkuCostPriceHis> selectByExample(SkuCostPriceHisExample example);

    SkuCostPriceHis selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SkuCostPriceHis record, @Param("example") SkuCostPriceHisExample example);

    int updateByExample(@Param("record") SkuCostPriceHis record, @Param("example") SkuCostPriceHisExample example);

    int updateByPrimaryKeySelective(SkuCostPriceHis record);

    int updateByPrimaryKey(SkuCostPriceHis record);
}