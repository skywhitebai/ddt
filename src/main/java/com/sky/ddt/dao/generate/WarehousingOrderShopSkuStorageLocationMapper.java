package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.WarehousingOrderShopSkuStorageLocation;
import com.sky.ddt.entity.WarehousingOrderShopSkuStorageLocationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WarehousingOrderShopSkuStorageLocationMapper {
    long countByExample(WarehousingOrderShopSkuStorageLocationExample example);

    int deleteByExample(WarehousingOrderShopSkuStorageLocationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WarehousingOrderShopSkuStorageLocation record);

    int insertSelective(WarehousingOrderShopSkuStorageLocation record);

    List<WarehousingOrderShopSkuStorageLocation> selectByExample(WarehousingOrderShopSkuStorageLocationExample example);

    WarehousingOrderShopSkuStorageLocation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WarehousingOrderShopSkuStorageLocation record, @Param("example") WarehousingOrderShopSkuStorageLocationExample example);

    int updateByExample(@Param("record") WarehousingOrderShopSkuStorageLocation record, @Param("example") WarehousingOrderShopSkuStorageLocationExample example);

    int updateByPrimaryKeySelective(WarehousingOrderShopSkuStorageLocation record);

    int updateByPrimaryKey(WarehousingOrderShopSkuStorageLocation record);
}