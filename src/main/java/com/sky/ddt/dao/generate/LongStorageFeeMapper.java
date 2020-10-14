package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.LongStorageFee;
import com.sky.ddt.entity.LongStorageFeeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LongStorageFeeMapper {
    long countByExample(LongStorageFeeExample example);

    int deleteByExample(LongStorageFeeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LongStorageFee record);

    int insertSelective(LongStorageFee record);

    List<LongStorageFee> selectByExample(LongStorageFeeExample example);

    LongStorageFee selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LongStorageFee record, @Param("example") LongStorageFeeExample example);

    int updateByExample(@Param("record") LongStorageFee record, @Param("example") LongStorageFeeExample example);

    int updateByPrimaryKeySelective(LongStorageFee record);

    int updateByPrimaryKey(LongStorageFee record);
}