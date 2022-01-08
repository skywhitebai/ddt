package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.ShopSkuStorageLocation;
import com.sky.ddt.entity.ShopSkuStorageLocationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopSkuStorageLocationMapper {
    long countByExample(ShopSkuStorageLocationExample example);

    int deleteByExample(ShopSkuStorageLocationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ShopSkuStorageLocation record);

    int insertSelective(ShopSkuStorageLocation record);

    List<ShopSkuStorageLocation> selectByExample(ShopSkuStorageLocationExample example);

    ShopSkuStorageLocation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ShopSkuStorageLocation record, @Param("example") ShopSkuStorageLocationExample example);

    int updateByExample(@Param("record") ShopSkuStorageLocation record, @Param("example") ShopSkuStorageLocationExample example);

    int updateByPrimaryKeySelective(ShopSkuStorageLocation record);

    int updateByPrimaryKey(ShopSkuStorageLocation record);
}