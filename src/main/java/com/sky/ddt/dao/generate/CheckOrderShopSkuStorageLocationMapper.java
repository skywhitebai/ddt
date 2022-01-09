package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.CheckOrderShopSkuStorageLocation;
import com.sky.ddt.entity.CheckOrderShopSkuStorageLocationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CheckOrderShopSkuStorageLocationMapper {
    long countByExample(CheckOrderShopSkuStorageLocationExample example);

    int deleteByExample(CheckOrderShopSkuStorageLocationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CheckOrderShopSkuStorageLocation record);

    int insertSelective(CheckOrderShopSkuStorageLocation record);

    List<CheckOrderShopSkuStorageLocation> selectByExample(CheckOrderShopSkuStorageLocationExample example);

    CheckOrderShopSkuStorageLocation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CheckOrderShopSkuStorageLocation record, @Param("example") CheckOrderShopSkuStorageLocationExample example);

    int updateByExample(@Param("record") CheckOrderShopSkuStorageLocation record, @Param("example") CheckOrderShopSkuStorageLocationExample example);

    int updateByPrimaryKeySelective(CheckOrderShopSkuStorageLocation record);

    int updateByPrimaryKey(CheckOrderShopSkuStorageLocation record);
}