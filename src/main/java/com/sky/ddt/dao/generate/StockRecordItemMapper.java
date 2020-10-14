package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.StockRecordItem;
import com.sky.ddt.entity.StockRecordItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StockRecordItemMapper {
    long countByExample(StockRecordItemExample example);

    int deleteByExample(StockRecordItemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StockRecordItem record);

    int insertSelective(StockRecordItem record);

    List<StockRecordItem> selectByExample(StockRecordItemExample example);

    StockRecordItem selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StockRecordItem record, @Param("example") StockRecordItemExample example);

    int updateByExample(@Param("record") StockRecordItem record, @Param("example") StockRecordItemExample example);

    int updateByPrimaryKeySelective(StockRecordItem record);

    int updateByPrimaryKey(StockRecordItem record);
}