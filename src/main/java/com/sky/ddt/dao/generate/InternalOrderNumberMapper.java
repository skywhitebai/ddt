package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.InternalOrderNumber;
import com.sky.ddt.entity.InternalOrderNumberExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InternalOrderNumberMapper {
    long countByExample(InternalOrderNumberExample example);

    int deleteByExample(InternalOrderNumberExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(InternalOrderNumber record);

    int insertSelective(InternalOrderNumber record);

    List<InternalOrderNumber> selectByExample(InternalOrderNumberExample example);

    InternalOrderNumber selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") InternalOrderNumber record, @Param("example") InternalOrderNumberExample example);

    int updateByExample(@Param("record") InternalOrderNumber record, @Param("example") InternalOrderNumberExample example);

    int updateByPrimaryKeySelective(InternalOrderNumber record);

    int updateByPrimaryKey(InternalOrderNumber record);
}