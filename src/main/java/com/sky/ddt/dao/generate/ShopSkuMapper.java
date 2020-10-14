package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.ShopSku;
import com.sky.ddt.entity.ShopSkuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopSkuMapper {
    long countByExample(ShopSkuExample example);

    int deleteByExample(ShopSkuExample example);

    int deleteByPrimaryKey(Integer shopSkuId);

    int insert(ShopSku record);

    int insertSelective(ShopSku record);

    List<ShopSku> selectByExample(ShopSkuExample example);

    ShopSku selectByPrimaryKey(Integer shopSkuId);

    int updateByExampleSelective(@Param("record") ShopSku record, @Param("example") ShopSkuExample example);

    int updateByExample(@Param("record") ShopSku record, @Param("example") ShopSkuExample example);

    int updateByPrimaryKeySelective(ShopSku record);

    int updateByPrimaryKey(ShopSku record);
}