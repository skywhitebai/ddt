package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.ProductImg;
import com.sky.ddt.entity.ProductImgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductImgMapper {
    long countByExample(ProductImgExample example);

    int deleteByExample(ProductImgExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProductImg record);

    int insertSelective(ProductImg record);

    List<ProductImg> selectByExampleWithBLOBs(ProductImgExample example);

    List<ProductImg> selectByExample(ProductImgExample example);

    ProductImg selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProductImg record, @Param("example") ProductImgExample example);

    int updateByExampleWithBLOBs(@Param("record") ProductImg record, @Param("example") ProductImgExample example);

    int updateByExample(@Param("record") ProductImg record, @Param("example") ProductImgExample example);

    int updateByPrimaryKeySelective(ProductImg record);

    int updateByPrimaryKeyWithBLOBs(ProductImg record);

    int updateByPrimaryKey(ProductImg record);
}