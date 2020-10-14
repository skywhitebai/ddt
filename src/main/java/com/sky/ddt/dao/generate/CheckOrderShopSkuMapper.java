package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.CheckOrderShopSku;
import com.sky.ddt.entity.CheckOrderShopSkuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CheckOrderShopSkuMapper {
    long countByExample(CheckOrderShopSkuExample example);

    int deleteByExample(CheckOrderShopSkuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CheckOrderShopSku record);

    int insertSelective(CheckOrderShopSku record);

    List<CheckOrderShopSku> selectByExample(CheckOrderShopSkuExample example);

    CheckOrderShopSku selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CheckOrderShopSku record, @Param("example") CheckOrderShopSkuExample example);

    int updateByExample(@Param("record") CheckOrderShopSku record, @Param("example") CheckOrderShopSkuExample example);

    int updateByPrimaryKeySelective(CheckOrderShopSku record);

    int updateByPrimaryKey(CheckOrderShopSku record);
}