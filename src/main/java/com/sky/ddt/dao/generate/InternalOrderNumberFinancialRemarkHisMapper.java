package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.InternalOrderNumberFinancialRemarkHis;
import com.sky.ddt.entity.InternalOrderNumberFinancialRemarkHisExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InternalOrderNumberFinancialRemarkHisMapper {
    long countByExample(InternalOrderNumberFinancialRemarkHisExample example);

    int deleteByExample(InternalOrderNumberFinancialRemarkHisExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(InternalOrderNumberFinancialRemarkHis record);

    int insertSelective(InternalOrderNumberFinancialRemarkHis record);

    List<InternalOrderNumberFinancialRemarkHis> selectByExample(InternalOrderNumberFinancialRemarkHisExample example);

    InternalOrderNumberFinancialRemarkHis selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") InternalOrderNumberFinancialRemarkHis record, @Param("example") InternalOrderNumberFinancialRemarkHisExample example);

    int updateByExample(@Param("record") InternalOrderNumberFinancialRemarkHis record, @Param("example") InternalOrderNumberFinancialRemarkHisExample example);

    int updateByPrimaryKeySelective(InternalOrderNumberFinancialRemarkHis record);

    int updateByPrimaryKey(InternalOrderNumberFinancialRemarkHis record);
}