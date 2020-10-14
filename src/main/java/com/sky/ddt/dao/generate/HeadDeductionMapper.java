package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.HeadDeduction;
import com.sky.ddt.entity.HeadDeductionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HeadDeductionMapper {
    long countByExample(HeadDeductionExample example);

    int deleteByExample(HeadDeductionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(HeadDeduction record);

    int insertSelective(HeadDeduction record);

    List<HeadDeduction> selectByExample(HeadDeductionExample example);

    HeadDeduction selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") HeadDeduction record, @Param("example") HeadDeductionExample example);

    int updateByExample(@Param("record") HeadDeduction record, @Param("example") HeadDeductionExample example);

    int updateByPrimaryKeySelective(HeadDeduction record);

    int updateByPrimaryKey(HeadDeduction record);
}