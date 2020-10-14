package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.RemoveOrders;
import com.sky.ddt.entity.RemoveOrdersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RemoveOrdersMapper {
    long countByExample(RemoveOrdersExample example);

    int deleteByExample(RemoveOrdersExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RemoveOrders record);

    int insertSelective(RemoveOrders record);

    List<RemoveOrders> selectByExample(RemoveOrdersExample example);

    RemoveOrders selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RemoveOrders record, @Param("example") RemoveOrdersExample example);

    int updateByExample(@Param("record") RemoveOrders record, @Param("example") RemoveOrdersExample example);

    int updateByPrimaryKeySelective(RemoveOrders record);

    int updateByPrimaryKey(RemoveOrders record);
}