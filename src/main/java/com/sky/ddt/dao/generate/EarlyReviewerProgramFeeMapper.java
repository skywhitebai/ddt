package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.EarlyReviewerProgramFee;
import com.sky.ddt.entity.EarlyReviewerProgramFeeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EarlyReviewerProgramFeeMapper {
    long countByExample(EarlyReviewerProgramFeeExample example);

    int deleteByExample(EarlyReviewerProgramFeeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EarlyReviewerProgramFee record);

    int insertSelective(EarlyReviewerProgramFee record);

    List<EarlyReviewerProgramFee> selectByExample(EarlyReviewerProgramFeeExample example);

    EarlyReviewerProgramFee selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EarlyReviewerProgramFee record, @Param("example") EarlyReviewerProgramFeeExample example);

    int updateByExample(@Param("record") EarlyReviewerProgramFee record, @Param("example") EarlyReviewerProgramFeeExample example);

    int updateByPrimaryKeySelective(EarlyReviewerProgramFee record);

    int updateByPrimaryKey(EarlyReviewerProgramFee record);
}