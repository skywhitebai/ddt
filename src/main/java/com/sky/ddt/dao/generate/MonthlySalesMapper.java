package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.MonthlySales;
import com.sky.ddt.entity.MonthlySalesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MonthlySalesMapper {
    long countByExample(MonthlySalesExample example);

    int deleteByExample(MonthlySalesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MonthlySales record);

    int insertSelective(MonthlySales record);

    List<MonthlySales> selectByExample(MonthlySalesExample example);

    MonthlySales selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MonthlySales record, @Param("example") MonthlySalesExample example);

    int updateByExample(@Param("record") MonthlySales record, @Param("example") MonthlySalesExample example);

    int updateByPrimaryKeySelective(MonthlySales record);

    int updateByPrimaryKey(MonthlySales record);
}