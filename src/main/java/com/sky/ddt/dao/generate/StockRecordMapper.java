package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.StockRecord;
import com.sky.ddt.entity.StockRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StockRecordMapper {
    long countByExample(StockRecordExample example);

    int deleteByExample(StockRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StockRecord record);

    int insertSelective(StockRecord record);

    List<StockRecord> selectByExample(StockRecordExample example);

    StockRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StockRecord record, @Param("example") StockRecordExample example);

    int updateByExample(@Param("record") StockRecord record, @Param("example") StockRecordExample example);

    int updateByPrimaryKeySelective(StockRecord record);

    int updateByPrimaryKey(StockRecord record);
}