package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.ShopHeadTripCost;
import com.sky.ddt.entity.ShopHeadTripCostExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopHeadTripCostMapper {
    long countByExample(ShopHeadTripCostExample example);

    int deleteByExample(ShopHeadTripCostExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ShopHeadTripCost record);

    int insertSelective(ShopHeadTripCost record);

    List<ShopHeadTripCost> selectByExample(ShopHeadTripCostExample example);

    ShopHeadTripCost selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ShopHeadTripCost record, @Param("example") ShopHeadTripCostExample example);

    int updateByExample(@Param("record") ShopHeadTripCost record, @Param("example") ShopHeadTripCostExample example);

    int updateByPrimaryKeySelective(ShopHeadTripCost record);

    int updateByPrimaryKey(ShopHeadTripCost record);
}