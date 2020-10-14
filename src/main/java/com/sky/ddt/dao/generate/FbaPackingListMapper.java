package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.FbaPackingList;
import com.sky.ddt.entity.FbaPackingListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FbaPackingListMapper {
    long countByExample(FbaPackingListExample example);

    int deleteByExample(FbaPackingListExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FbaPackingList record);

    int insertSelective(FbaPackingList record);

    List<FbaPackingList> selectByExample(FbaPackingListExample example);

    FbaPackingList selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FbaPackingList record, @Param("example") FbaPackingListExample example);

    int updateByExample(@Param("record") FbaPackingList record, @Param("example") FbaPackingListExample example);

    int updateByPrimaryKeySelective(FbaPackingList record);

    int updateByPrimaryKey(FbaPackingList record);
}