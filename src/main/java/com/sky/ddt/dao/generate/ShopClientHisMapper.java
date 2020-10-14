package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.ShopClientHis;
import com.sky.ddt.entity.ShopClientHisExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopClientHisMapper {
    long countByExample(ShopClientHisExample example);

    int deleteByExample(ShopClientHisExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ShopClientHis record);

    int insertSelective(ShopClientHis record);

    List<ShopClientHis> selectByExample(ShopClientHisExample example);

    ShopClientHis selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ShopClientHis record, @Param("example") ShopClientHisExample example);

    int updateByExample(@Param("record") ShopClientHis record, @Param("example") ShopClientHisExample example);

    int updateByPrimaryKeySelective(ShopClientHis record);

    int updateByPrimaryKey(ShopClientHis record);
}