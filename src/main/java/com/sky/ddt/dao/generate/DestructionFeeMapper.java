package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.DestructionFee;
import com.sky.ddt.entity.DestructionFeeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DestructionFeeMapper {
    long countByExample(DestructionFeeExample example);

    int deleteByExample(DestructionFeeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DestructionFee record);

    int insertSelective(DestructionFee record);

    List<DestructionFee> selectByExample(DestructionFeeExample example);

    DestructionFee selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DestructionFee record, @Param("example") DestructionFeeExample example);

    int updateByExample(@Param("record") DestructionFee record, @Param("example") DestructionFeeExample example);

    int updateByPrimaryKeySelective(DestructionFee record);

    int updateByPrimaryKey(DestructionFee record);
}