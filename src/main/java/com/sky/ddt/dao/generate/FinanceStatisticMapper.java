package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.FinanceStatistic;
import com.sky.ddt.entity.FinanceStatisticExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FinanceStatisticMapper {
    long countByExample(FinanceStatisticExample example);

    int deleteByExample(FinanceStatisticExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FinanceStatistic record);

    int insertSelective(FinanceStatistic record);

    List<FinanceStatistic> selectByExample(FinanceStatisticExample example);

    FinanceStatistic selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FinanceStatistic record, @Param("example") FinanceStatisticExample example);

    int updateByExample(@Param("record") FinanceStatistic record, @Param("example") FinanceStatisticExample example);

    int updateByPrimaryKeySelective(FinanceStatistic record);

    int updateByPrimaryKey(FinanceStatistic record);
}