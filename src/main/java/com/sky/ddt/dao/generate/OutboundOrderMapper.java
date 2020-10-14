package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.OutboundOrder;
import com.sky.ddt.entity.OutboundOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OutboundOrderMapper {
    long countByExample(OutboundOrderExample example);

    int deleteByExample(OutboundOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OutboundOrder record);

    int insertSelective(OutboundOrder record);

    List<OutboundOrder> selectByExample(OutboundOrderExample example);

    OutboundOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OutboundOrder record, @Param("example") OutboundOrderExample example);

    int updateByExample(@Param("record") OutboundOrder record, @Param("example") OutboundOrderExample example);

    int updateByPrimaryKeySelective(OutboundOrder record);

    int updateByPrimaryKey(OutboundOrder record);
}