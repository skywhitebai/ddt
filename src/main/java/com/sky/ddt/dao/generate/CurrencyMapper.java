package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.Currency;
import com.sky.ddt.entity.CurrencyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CurrencyMapper {
    long countByExample(CurrencyExample example);

    int deleteByExample(CurrencyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Currency record);

    int insertSelective(Currency record);

    List<Currency> selectByExample(CurrencyExample example);

    Currency selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Currency record, @Param("example") CurrencyExample example);

    int updateByExample(@Param("record") Currency record, @Param("example") CurrencyExample example);

    int updateByPrimaryKeySelective(Currency record);

    int updateByPrimaryKey(Currency record);
}