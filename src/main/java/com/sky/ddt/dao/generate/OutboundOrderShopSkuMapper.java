package com.sky.ddt.dao.generate;

import com.sky.ddt.entity.OutboundOrderShopSku;
import com.sky.ddt.entity.OutboundOrderShopSkuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OutboundOrderShopSkuMapper {
    long countByExample(OutboundOrderShopSkuExample example);

    int deleteByExample(OutboundOrderShopSkuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OutboundOrderShopSku record);

    int insertSelective(OutboundOrderShopSku record);

    List<OutboundOrderShopSku> selectByExample(OutboundOrderShopSkuExample example);

    OutboundOrderShopSku selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OutboundOrderShopSku record, @Param("example") OutboundOrderShopSkuExample example);

    int updateByExample(@Param("record") OutboundOrderShopSku record, @Param("example") OutboundOrderShopSkuExample example);

    int updateByPrimaryKeySelective(OutboundOrderShopSku record);

    int updateByPrimaryKey(OutboundOrderShopSku record);
}