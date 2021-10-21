package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.ProductLabourCostHis;
import com.sky.ddt.entity.ProductLabourCostHisExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductLabourCostHisMapper {
    long countByExample(ProductLabourCostHisExample example);

    int deleteByExample(ProductLabourCostHisExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProductLabourCostHis record);

    int insertSelective(ProductLabourCostHis record);

    List<ProductLabourCostHis> selectByExample(ProductLabourCostHisExample example);

    ProductLabourCostHis selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProductLabourCostHis record, @Param("example") ProductLabourCostHisExample example);

    int updateByExample(@Param("record") ProductLabourCostHis record, @Param("example") ProductLabourCostHisExample example);

    int updateByPrimaryKeySelective(ProductLabourCostHis record);

    int updateByPrimaryKey(ProductLabourCostHis record);
}