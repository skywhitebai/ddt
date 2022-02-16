package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.FinancialDocument;
import com.sky.ddt.entity.FinancialDocumentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FinancialDocumentMapper {
    long countByExample(FinancialDocumentExample example);

    int deleteByExample(FinancialDocumentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FinancialDocument record);

    int insertSelective(FinancialDocument record);

    List<FinancialDocument> selectByExample(FinancialDocumentExample example);

    FinancialDocument selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FinancialDocument record, @Param("example") FinancialDocumentExample example);

    int updateByExample(@Param("record") FinancialDocument record, @Param("example") FinancialDocumentExample example);

    int updateByPrimaryKeySelective(FinancialDocument record);

    int updateByPrimaryKey(FinancialDocument record);
}