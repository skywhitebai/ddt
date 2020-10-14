package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.SkuInfo;
import com.sky.ddt.entity.SkuInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SkuInfoMapper {
    long countByExample(SkuInfoExample example);

    int deleteByExample(SkuInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SkuInfo record);

    int insertSelective(SkuInfo record);

    List<SkuInfo> selectByExample(SkuInfoExample example);

    SkuInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SkuInfo record, @Param("example") SkuInfoExample example);

    int updateByExample(@Param("record") SkuInfo record, @Param("example") SkuInfoExample example);

    int updateByPrimaryKeySelective(SkuInfo record);

    int updateByPrimaryKey(SkuInfo record);
}