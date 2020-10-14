package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.FbaPackingListShopSku;
import com.sky.ddt.entity.FbaPackingListShopSkuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FbaPackingListShopSkuMapper {
    long countByExample(FbaPackingListShopSkuExample example);

    int deleteByExample(FbaPackingListShopSkuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FbaPackingListShopSku record);

    int insertSelective(FbaPackingListShopSku record);

    List<FbaPackingListShopSku> selectByExample(FbaPackingListShopSkuExample example);

    FbaPackingListShopSku selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FbaPackingListShopSku record, @Param("example") FbaPackingListShopSkuExample example);

    int updateByExample(@Param("record") FbaPackingListShopSku record, @Param("example") FbaPackingListShopSkuExample example);

    int updateByPrimaryKeySelective(FbaPackingListShopSku record);

    int updateByPrimaryKey(FbaPackingListShopSku record);
}