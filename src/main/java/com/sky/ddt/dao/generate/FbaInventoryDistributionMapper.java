package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.FbaInventoryDistribution;
import com.sky.ddt.entity.FbaInventoryDistributionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FbaInventoryDistributionMapper {
    long countByExample(FbaInventoryDistributionExample example);

    int deleteByExample(FbaInventoryDistributionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FbaInventoryDistribution record);

    int insertSelective(FbaInventoryDistribution record);

    List<FbaInventoryDistribution> selectByExample(FbaInventoryDistributionExample example);

    FbaInventoryDistribution selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FbaInventoryDistribution record, @Param("example") FbaInventoryDistributionExample example);

    int updateByExample(@Param("record") FbaInventoryDistribution record, @Param("example") FbaInventoryDistributionExample example);

    int updateByPrimaryKeySelective(FbaInventoryDistribution record);

    int updateByPrimaryKey(FbaInventoryDistribution record);
}