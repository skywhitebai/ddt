package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.StorageLocation;
import com.sky.ddt.entity.StorageLocationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StorageLocationMapper {
    long countByExample(StorageLocationExample example);

    int deleteByExample(StorageLocationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StorageLocation record);

    int insertSelective(StorageLocation record);

    List<StorageLocation> selectByExample(StorageLocationExample example);

    StorageLocation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StorageLocation record, @Param("example") StorageLocationExample example);

    int updateByExample(@Param("record") StorageLocation record, @Param("example") StorageLocationExample example);

    int updateByPrimaryKeySelective(StorageLocation record);

    int updateByPrimaryKey(StorageLocation record);
}