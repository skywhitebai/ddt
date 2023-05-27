package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.StockRecordItemPrintRecord;
import com.sky.ddt.entity.StockRecordItemPrintRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StockRecordItemPrintRecordMapper {
    long countByExample(StockRecordItemPrintRecordExample example);

    int deleteByExample(StockRecordItemPrintRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StockRecordItemPrintRecord record);

    int insertSelective(StockRecordItemPrintRecord record);

    List<StockRecordItemPrintRecord> selectByExample(StockRecordItemPrintRecordExample example);

    StockRecordItemPrintRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StockRecordItemPrintRecord record, @Param("example") StockRecordItemPrintRecordExample example);

    int updateByExample(@Param("record") StockRecordItemPrintRecord record, @Param("example") StockRecordItemPrintRecordExample example);

    int updateByPrimaryKeySelective(StockRecordItemPrintRecord record);

    int updateByPrimaryKey(StockRecordItemPrintRecord record);
}