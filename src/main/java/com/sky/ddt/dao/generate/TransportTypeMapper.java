package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.TransportType;
import com.sky.ddt.entity.TransportTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TransportTypeMapper {
    long countByExample(TransportTypeExample example);

    int deleteByExample(TransportTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TransportType record);

    int insertSelective(TransportType record);

    List<TransportType> selectByExample(TransportTypeExample example);

    TransportType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TransportType record, @Param("example") TransportTypeExample example);

    int updateByExample(@Param("record") TransportType record, @Param("example") TransportTypeExample example);

    int updateByPrimaryKeySelective(TransportType record);

    int updateByPrimaryKey(TransportType record);
}