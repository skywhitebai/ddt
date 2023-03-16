package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.FbaPackingListRemarkHis;
import com.sky.ddt.entity.FbaPackingListRemarkHisExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FbaPackingListRemarkHisMapper {
    long countByExample(FbaPackingListRemarkHisExample example);

    int deleteByExample(FbaPackingListRemarkHisExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FbaPackingListRemarkHis record);

    int insertSelective(FbaPackingListRemarkHis record);

    List<FbaPackingListRemarkHis> selectByExample(FbaPackingListRemarkHisExample example);

    FbaPackingListRemarkHis selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FbaPackingListRemarkHis record, @Param("example") FbaPackingListRemarkHisExample example);

    int updateByExample(@Param("record") FbaPackingListRemarkHis record, @Param("example") FbaPackingListRemarkHisExample example);

    int updateByPrimaryKeySelective(FbaPackingListRemarkHis record);

    int updateByPrimaryKey(FbaPackingListRemarkHis record);
}