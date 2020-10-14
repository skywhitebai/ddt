package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.InternalOrderNumberTransport;
import com.sky.ddt.entity.InternalOrderNumberTransportExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InternalOrderNumberTransportMapper {
    long countByExample(InternalOrderNumberTransportExample example);

    int deleteByExample(InternalOrderNumberTransportExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(InternalOrderNumberTransport record);

    int insertSelective(InternalOrderNumberTransport record);

    List<InternalOrderNumberTransport> selectByExample(InternalOrderNumberTransportExample example);

    InternalOrderNumberTransport selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") InternalOrderNumberTransport record, @Param("example") InternalOrderNumberTransportExample example);

    int updateByExample(@Param("record") InternalOrderNumberTransport record, @Param("example") InternalOrderNumberTransportExample example);

    int updateByPrimaryKeySelective(InternalOrderNumberTransport record);

    int updateByPrimaryKey(InternalOrderNumberTransport record);
}