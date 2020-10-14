package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.TransferOrderShopSku;
import com.sky.ddt.entity.TransferOrderShopSkuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TransferOrderShopSkuMapper {
    long countByExample(TransferOrderShopSkuExample example);

    int deleteByExample(TransferOrderShopSkuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TransferOrderShopSku record);

    int insertSelective(TransferOrderShopSku record);

    List<TransferOrderShopSku> selectByExample(TransferOrderShopSkuExample example);

    TransferOrderShopSku selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TransferOrderShopSku record, @Param("example") TransferOrderShopSkuExample example);

    int updateByExample(@Param("record") TransferOrderShopSku record, @Param("example") TransferOrderShopSkuExample example);

    int updateByPrimaryKeySelective(TransferOrderShopSku record);

    int updateByPrimaryKey(TransferOrderShopSku record);
}