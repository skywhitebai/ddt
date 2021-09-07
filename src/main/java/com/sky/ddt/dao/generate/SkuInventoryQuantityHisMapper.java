package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.SkuInventoryQuantityHis;
import com.sky.ddt.entity.SkuInventoryQuantityHisExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SkuInventoryQuantityHisMapper {
    long countByExample(SkuInventoryQuantityHisExample example);

    int deleteByExample(SkuInventoryQuantityHisExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SkuInventoryQuantityHis record);

    int insertSelective(SkuInventoryQuantityHis record);

    List<SkuInventoryQuantityHis> selectByExample(SkuInventoryQuantityHisExample example);

    SkuInventoryQuantityHis selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SkuInventoryQuantityHis record, @Param("example") SkuInventoryQuantityHisExample example);

    int updateByExample(@Param("record") SkuInventoryQuantityHis record, @Param("example") SkuInventoryQuantityHisExample example);

    int updateByPrimaryKeySelective(SkuInventoryQuantityHis record);

    int updateByPrimaryKey(SkuInventoryQuantityHis record);
}