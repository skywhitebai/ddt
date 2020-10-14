package com.sky.ddt.dto.skuCostPriceHis.response;

import com.sky.ddt.entity.SkuCostPriceHis;
import lombok.Data;

/**
 * @author baixueping
 * @description sku成本价历史
 * @date 2019/12/31 10:04
 */
@Data
public class ListSkuCostPriceHisResponse extends SkuCostPriceHis{
    String createUserName;
    String typeName;
    String sku;
}
