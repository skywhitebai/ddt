package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.FactoryProductionOrderShopSku;
import com.sky.ddt.entity.FactoryProductionOrderShopSkuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FactoryProductionOrderShopSkuMapper {
    long countByExample(FactoryProductionOrderShopSkuExample example);

    int deleteByExample(FactoryProductionOrderShopSkuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FactoryProductionOrderShopSku record);

    int insertSelective(FactoryProductionOrderShopSku record);

    List<FactoryProductionOrderShopSku> selectByExample(FactoryProductionOrderShopSkuExample example);

    FactoryProductionOrderShopSku selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FactoryProductionOrderShopSku record, @Param("example") FactoryProductionOrderShopSkuExample example);

    int updateByExample(@Param("record") FactoryProductionOrderShopSku record, @Param("example") FactoryProductionOrderShopSkuExample example);

    int updateByPrimaryKeySelective(FactoryProductionOrderShopSku record);

    int updateByPrimaryKey(FactoryProductionOrderShopSku record);
}