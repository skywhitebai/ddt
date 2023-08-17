package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.RefundOrder;
import com.sky.ddt.entity.RefundOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RefundOrderMapper {
    long countByExample(RefundOrderExample example);

    int deleteByExample(RefundOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RefundOrder record);

    int insertSelective(RefundOrder record);

    List<RefundOrder> selectByExample(RefundOrderExample example);

    RefundOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RefundOrder record, @Param("example") RefundOrderExample example);

    int updateByExample(@Param("record") RefundOrder record, @Param("example") RefundOrderExample example);

    int updateByPrimaryKeySelective(RefundOrder record);

    int updateByPrimaryKey(RefundOrder record);
}