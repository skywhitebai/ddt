package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.FinancialStatement;
import com.sky.ddt.entity.FinancialStatementExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FinancialStatementMapper {
    long countByExample(FinancialStatementExample example);

    int deleteByExample(FinancialStatementExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FinancialStatement record);

    int insertSelective(FinancialStatement record);

    List<FinancialStatement> selectByExample(FinancialStatementExample example);

    FinancialStatement selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FinancialStatement record, @Param("example") FinancialStatementExample example);

    int updateByExample(@Param("record") FinancialStatement record, @Param("example") FinancialStatementExample example);

    int updateByPrimaryKeySelective(FinancialStatement record);

    int updateByPrimaryKey(FinancialStatement record);
}