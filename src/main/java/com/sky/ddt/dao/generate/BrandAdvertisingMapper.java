package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.BrandAdvertising;
import com.sky.ddt.entity.BrandAdvertisingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BrandAdvertisingMapper {
    long countByExample(BrandAdvertisingExample example);

    int deleteByExample(BrandAdvertisingExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BrandAdvertising record);

    int insertSelective(BrandAdvertising record);

    List<BrandAdvertising> selectByExample(BrandAdvertisingExample example);

    BrandAdvertising selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BrandAdvertising record, @Param("example") BrandAdvertisingExample example);

    int updateByExample(@Param("record") BrandAdvertising record, @Param("example") BrandAdvertisingExample example);

    int updateByPrimaryKeySelective(BrandAdvertising record);

    int updateByPrimaryKey(BrandAdvertising record);
}