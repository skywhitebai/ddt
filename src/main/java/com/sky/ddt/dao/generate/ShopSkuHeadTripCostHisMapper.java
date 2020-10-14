package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.ShopSkuHeadTripCostHis;
import com.sky.ddt.entity.ShopSkuHeadTripCostHisExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopSkuHeadTripCostHisMapper {
    long countByExample(ShopSkuHeadTripCostHisExample example);

    int deleteByExample(ShopSkuHeadTripCostHisExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ShopSkuHeadTripCostHis record);

    int insertSelective(ShopSkuHeadTripCostHis record);

    List<ShopSkuHeadTripCostHis> selectByExample(ShopSkuHeadTripCostHisExample example);

    ShopSkuHeadTripCostHis selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ShopSkuHeadTripCostHis record, @Param("example") ShopSkuHeadTripCostHisExample example);

    int updateByExample(@Param("record") ShopSkuHeadTripCostHis record, @Param("example") ShopSkuHeadTripCostHisExample example);

    int updateByPrimaryKeySelective(ShopSkuHeadTripCostHis record);

    int updateByPrimaryKey(ShopSkuHeadTripCostHis record);
}