package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.AmazonOrder;
import com.sky.ddt.entity.AmazonOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AmazonOrderMapper {
    long countByExample(AmazonOrderExample example);

    int deleteByExample(AmazonOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AmazonOrder record);

    int insertSelective(AmazonOrder record);

    List<AmazonOrder> selectByExample(AmazonOrderExample example);

    AmazonOrder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AmazonOrder record, @Param("example") AmazonOrderExample example);

    int updateByExample(@Param("record") AmazonOrder record, @Param("example") AmazonOrderExample example);

    int updateByPrimaryKeySelective(AmazonOrder record);

    int updateByPrimaryKey(AmazonOrder record);
}