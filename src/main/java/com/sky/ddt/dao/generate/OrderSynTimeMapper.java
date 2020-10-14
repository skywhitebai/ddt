package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.OrderSynTime;
import com.sky.ddt.entity.OrderSynTimeExample;
import com.sky.ddt.entity.OrderSynTimeKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderSynTimeMapper {
    long countByExample(OrderSynTimeExample example);

    int deleteByExample(OrderSynTimeExample example);

    int deleteByPrimaryKey(OrderSynTimeKey key);

    int insert(OrderSynTime record);

    int insertSelective(OrderSynTime record);

    List<OrderSynTime> selectByExample(OrderSynTimeExample example);

    OrderSynTime selectByPrimaryKey(OrderSynTimeKey key);

    int updateByExampleSelective(@Param("record") OrderSynTime record, @Param("example") OrderSynTimeExample example);

    int updateByExample(@Param("record") OrderSynTime record, @Param("example") OrderSynTimeExample example);

    int updateByPrimaryKeySelective(OrderSynTime record);

    int updateByPrimaryKey(OrderSynTime record);
}