package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.ReturnOrder;
import com.sky.ddt.entity.ReturnOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReturnOrderMapper {
    long countByExample(ReturnOrderExample example);

    int deleteByExample(ReturnOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ReturnOrder record);

    int insertSelective(ReturnOrder record);

    List<ReturnOrder> selectByExample(ReturnOrderExample example);

    ReturnOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ReturnOrder record, @Param("example") ReturnOrderExample example);

    int updateByExample(@Param("record") ReturnOrder record, @Param("example") ReturnOrderExample example);

    int updateByPrimaryKeySelective(ReturnOrder record);

    int updateByPrimaryKey(ReturnOrder record);
}