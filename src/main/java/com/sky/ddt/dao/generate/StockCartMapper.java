package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.StockCart;
import com.sky.ddt.entity.StockCartExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StockCartMapper {
    long countByExample(StockCartExample example);

    int deleteByExample(StockCartExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StockCart record);

    int insertSelective(StockCart record);

    List<StockCart> selectByExample(StockCartExample example);

    StockCart selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StockCart record, @Param("example") StockCartExample example);

    int updateByExample(@Param("record") StockCart record, @Param("example") StockCartExample example);

    int updateByPrimaryKeySelective(StockCart record);

    int updateByPrimaryKey(StockCart record);
}