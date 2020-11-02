package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.ProduceOrderShopSku;
import com.sky.ddt.entity.ProduceOrderShopSkuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProduceOrderShopSkuMapper {
    long countByExample(ProduceOrderShopSkuExample example);

    int deleteByExample(ProduceOrderShopSkuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProduceOrderShopSku record);

    int insertSelective(ProduceOrderShopSku record);

    List<ProduceOrderShopSku> selectByExample(ProduceOrderShopSkuExample example);

    ProduceOrderShopSku selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProduceOrderShopSku record, @Param("example") ProduceOrderShopSkuExample example);

    int updateByExample(@Param("record") ProduceOrderShopSku record, @Param("example") ProduceOrderShopSkuExample example);

    int updateByPrimaryKeySelective(ProduceOrderShopSku record);

    int updateByPrimaryKey(ProduceOrderShopSku record);
}