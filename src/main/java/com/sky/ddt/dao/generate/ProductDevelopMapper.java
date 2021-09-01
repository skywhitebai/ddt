package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.ProductDevelop;
import com.sky.ddt.entity.ProductDevelopExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductDevelopMapper {
    long countByExample(ProductDevelopExample example);

    int deleteByExample(ProductDevelopExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProductDevelop record);

    int insertSelective(ProductDevelop record);

    List<ProductDevelop> selectByExample(ProductDevelopExample example);

    ProductDevelop selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProductDevelop record, @Param("example") ProductDevelopExample example);

    int updateByExample(@Param("record") ProductDevelop record, @Param("example") ProductDevelopExample example);

    int updateByPrimaryKeySelective(ProductDevelop record);

    int updateByPrimaryKey(ProductDevelop record);
}