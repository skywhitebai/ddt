package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.AmazonWarehouse;
import com.sky.ddt.entity.AmazonWarehouseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AmazonWarehouseMapper {
    long countByExample(AmazonWarehouseExample example);

    int deleteByExample(AmazonWarehouseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AmazonWarehouse record);

    int insertSelective(AmazonWarehouse record);

    List<AmazonWarehouse> selectByExample(AmazonWarehouseExample example);

    AmazonWarehouse selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AmazonWarehouse record, @Param("example") AmazonWarehouseExample example);

    int updateByExample(@Param("record") AmazonWarehouse record, @Param("example") AmazonWarehouseExample example);

    int updateByPrimaryKeySelective(AmazonWarehouse record);

    int updateByPrimaryKey(AmazonWarehouse record);
}