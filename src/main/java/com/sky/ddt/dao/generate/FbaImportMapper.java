package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.FbaImport;
import com.sky.ddt.entity.FbaImportExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FbaImportMapper {
    long countByExample(FbaImportExample example);

    int deleteByExample(FbaImportExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FbaImport record);

    int insertSelective(FbaImport record);

    List<FbaImport> selectByExample(FbaImportExample example);

    FbaImport selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FbaImport record, @Param("example") FbaImportExample example);

    int updateByExample(@Param("record") FbaImport record, @Param("example") FbaImportExample example);

    int updateByPrimaryKeySelective(FbaImport record);

    int updateByPrimaryKey(FbaImport record);
}