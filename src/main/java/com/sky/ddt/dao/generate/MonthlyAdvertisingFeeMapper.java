package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.MonthlyAdvertisingFee;
import com.sky.ddt.entity.MonthlyAdvertisingFeeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MonthlyAdvertisingFeeMapper {
    long countByExample(MonthlyAdvertisingFeeExample example);

    int deleteByExample(MonthlyAdvertisingFeeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MonthlyAdvertisingFee record);

    int insertSelective(MonthlyAdvertisingFee record);

    List<MonthlyAdvertisingFee> selectByExample(MonthlyAdvertisingFeeExample example);

    MonthlyAdvertisingFee selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MonthlyAdvertisingFee record, @Param("example") MonthlyAdvertisingFeeExample example);

    int updateByExample(@Param("record") MonthlyAdvertisingFee record, @Param("example") MonthlyAdvertisingFeeExample example);

    int updateByPrimaryKeySelective(MonthlyAdvertisingFee record);

    int updateByPrimaryKey(MonthlyAdvertisingFee record);
}