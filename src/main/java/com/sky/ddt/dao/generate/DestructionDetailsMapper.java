package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.DestructionDetails;
import com.sky.ddt.entity.DestructionDetailsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DestructionDetailsMapper {
    long countByExample(DestructionDetailsExample example);

    int deleteByExample(DestructionDetailsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DestructionDetails record);

    int insertSelective(DestructionDetails record);

    List<DestructionDetails> selectByExample(DestructionDetailsExample example);

    DestructionDetails selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DestructionDetails record, @Param("example") DestructionDetailsExample example);

    int updateByExample(@Param("record") DestructionDetails record, @Param("example") DestructionDetailsExample example);

    int updateByPrimaryKeySelective(DestructionDetails record);

    int updateByPrimaryKey(DestructionDetails record);
}