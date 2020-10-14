package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.OrderImport;
import com.sky.ddt.entity.OrderImportExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderImportMapper {
    long countByExample(OrderImportExample example);

    int deleteByExample(OrderImportExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrderImport record);

    int insertSelective(OrderImport record);

    List<OrderImport> selectByExample(OrderImportExample example);

    OrderImport selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrderImport record, @Param("example") OrderImportExample example);

    int updateByExample(@Param("record") OrderImport record, @Param("example") OrderImportExample example);

    int updateByPrimaryKeySelective(OrderImport record);

    int updateByPrimaryKey(OrderImport record);
}