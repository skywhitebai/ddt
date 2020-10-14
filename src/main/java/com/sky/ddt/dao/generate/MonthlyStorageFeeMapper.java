package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.MonthlyStorageFee;
import com.sky.ddt.entity.MonthlyStorageFeeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MonthlyStorageFeeMapper {
    long countByExample(MonthlyStorageFeeExample example);

    int deleteByExample(MonthlyStorageFeeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MonthlyStorageFee record);

    int insertSelective(MonthlyStorageFee record);

    List<MonthlyStorageFee> selectByExample(MonthlyStorageFeeExample example);

    MonthlyStorageFee selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MonthlyStorageFee record, @Param("example") MonthlyStorageFeeExample example);

    int updateByExample(@Param("record") MonthlyStorageFee record, @Param("example") MonthlyStorageFeeExample example);

    int updateByPrimaryKeySelective(MonthlyStorageFee record);

    int updateByPrimaryKey(MonthlyStorageFee record);
}