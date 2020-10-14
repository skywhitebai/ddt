package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.ProduceOrder;
import com.sky.ddt.entity.ProduceOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProduceOrderMapper {
    long countByExample(ProduceOrderExample example);

    int deleteByExample(ProduceOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProduceOrder record);

    int insertSelective(ProduceOrder record);

    List<ProduceOrder> selectByExample(ProduceOrderExample example);

    ProduceOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProduceOrder record, @Param("example") ProduceOrderExample example);

    int updateByExample(@Param("record") ProduceOrder record, @Param("example") ProduceOrderExample example);

    int updateByPrimaryKeySelective(ProduceOrder record);

    int updateByPrimaryKey(ProduceOrder record);
}