package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.SkuWeightHis;
import com.sky.ddt.entity.SkuWeightHisExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SkuWeightHisMapper {
    long countByExample(SkuWeightHisExample example);

    int deleteByExample(SkuWeightHisExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SkuWeightHis record);

    int insertSelective(SkuWeightHis record);

    List<SkuWeightHis> selectByExample(SkuWeightHisExample example);

    SkuWeightHis selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SkuWeightHis record, @Param("example") SkuWeightHisExample example);

    int updateByExample(@Param("record") SkuWeightHis record, @Param("example") SkuWeightHisExample example);

    int updateByPrimaryKeySelective(SkuWeightHis record);

    int updateByPrimaryKey(SkuWeightHis record);
}