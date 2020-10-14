package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.ImgData;
import com.sky.ddt.entity.ImgDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImgDataMapper {
    long countByExample(ImgDataExample example);

    int deleteByExample(ImgDataExample example);

    int deleteByPrimaryKey(Integer imgId);

    int insert(ImgData record);

    int insertSelective(ImgData record);

    List<ImgData> selectByExampleWithBLOBs(ImgDataExample example);

    List<ImgData> selectByExample(ImgDataExample example);

    ImgData selectByPrimaryKey(Integer imgId);

    int updateByExampleSelective(@Param("record") ImgData record, @Param("example") ImgDataExample example);

    int updateByExampleWithBLOBs(@Param("record") ImgData record, @Param("example") ImgDataExample example);

    int updateByExample(@Param("record") ImgData record, @Param("example") ImgDataExample example);

    int updateByPrimaryKeySelective(ImgData record);

    int updateByPrimaryKeyWithBLOBs(ImgData record);
}