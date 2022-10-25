package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.StockRemark;
import com.sky.ddt.entity.StockRemarkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StockRemarkMapper {
    long countByExample(StockRemarkExample example);

    int deleteByExample(StockRemarkExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StockRemark record);

    int insertSelective(StockRemark record);

    List<StockRemark> selectByExample(StockRemarkExample example);

    StockRemark selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StockRemark record, @Param("example") StockRemarkExample example);

    int updateByExample(@Param("record") StockRemark record, @Param("example") StockRemarkExample example);

    int updateByPrimaryKeySelective(StockRemark record);

    int updateByPrimaryKey(StockRemark record);
}