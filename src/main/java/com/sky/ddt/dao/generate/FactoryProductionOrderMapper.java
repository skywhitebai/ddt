package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.FactoryProductionOrder;
import com.sky.ddt.entity.FactoryProductionOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FactoryProductionOrderMapper {
    long countByExample(FactoryProductionOrderExample example);

    int deleteByExample(FactoryProductionOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FactoryProductionOrder record);

    int insertSelective(FactoryProductionOrder record);

    List<FactoryProductionOrder> selectByExample(FactoryProductionOrderExample example);

    FactoryProductionOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FactoryProductionOrder record, @Param("example") FactoryProductionOrderExample example);

    int updateByExample(@Param("record") FactoryProductionOrder record, @Param("example") FactoryProductionOrderExample example);

    int updateByPrimaryKeySelective(FactoryProductionOrder record);

    int updateByPrimaryKey(FactoryProductionOrder record);
}