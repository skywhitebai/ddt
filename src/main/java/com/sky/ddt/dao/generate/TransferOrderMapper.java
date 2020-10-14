package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.TransferOrder;
import com.sky.ddt.entity.TransferOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TransferOrderMapper {
    long countByExample(TransferOrderExample example);

    int deleteByExample(TransferOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TransferOrder record);

    int insertSelective(TransferOrder record);

    List<TransferOrder> selectByExample(TransferOrderExample example);

    TransferOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TransferOrder record, @Param("example") TransferOrderExample example);

    int updateByExample(@Param("record") TransferOrder record, @Param("example") TransferOrderExample example);

    int updateByPrimaryKeySelective(TransferOrder record);

    int updateByPrimaryKey(TransferOrder record);
}