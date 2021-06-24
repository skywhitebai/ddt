package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.AmazonSyncInfo;
import com.sky.ddt.entity.AmazonSyncInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AmazonSyncInfoMapper {
    long countByExample(AmazonSyncInfoExample example);

    int deleteByExample(AmazonSyncInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AmazonSyncInfo record);

    int insertSelective(AmazonSyncInfo record);

    List<AmazonSyncInfo> selectByExample(AmazonSyncInfoExample example);

    AmazonSyncInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AmazonSyncInfo record, @Param("example") AmazonSyncInfoExample example);

    int updateByExample(@Param("record") AmazonSyncInfo record, @Param("example") AmazonSyncInfoExample example);

    int updateByPrimaryKeySelective(AmazonSyncInfo record);

    int updateByPrimaryKey(AmazonSyncInfo record);
}