package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.ProductInventoryQuantityHis;
import com.sky.ddt.entity.ProductInventoryQuantityHisExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductInventoryQuantityHisMapper {
    long countByExample(ProductInventoryQuantityHisExample example);

    int deleteByExample(ProductInventoryQuantityHisExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProductInventoryQuantityHis record);

    int insertSelective(ProductInventoryQuantityHis record);

    List<ProductInventoryQuantityHis> selectByExample(ProductInventoryQuantityHisExample example);

    ProductInventoryQuantityHis selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ProductInventoryQuantityHis record, @Param("example") ProductInventoryQuantityHisExample example);

    int updateByExample(@Param("record") ProductInventoryQuantityHis record, @Param("example") ProductInventoryQuantityHisExample example);

    int updateByPrimaryKeySelective(ProductInventoryQuantityHis record);

    int updateByPrimaryKey(ProductInventoryQuantityHis record);
}