package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.JdSku;
import com.sky.ddt.entity.JdSkuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JdSkuMapper {
    long countByExample(JdSkuExample example);

    int deleteByExample(JdSkuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(JdSku record);

    int insertSelective(JdSku record);

    List<JdSku> selectByExample(JdSkuExample example);

    JdSku selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") JdSku record, @Param("example") JdSkuExample example);

    int updateByExample(@Param("record") JdSku record, @Param("example") JdSkuExample example);

    int updateByPrimaryKeySelective(JdSku record);

    int updateByPrimaryKey(JdSku record);
}