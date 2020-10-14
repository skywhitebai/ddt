package com.sky.ddt.dto.skuWeightHis.response;

import com.sky.ddt.entity.SkuWeightHis;
import lombok.Data;

/**
 * @author baixueping
 * @description sku重量历史
 * @date 2019/12/31 10:04
 */
@Data
public class ListSkuWeightHisResponse extends SkuWeightHis{
    String createUserName;
    String typeName;
    String sku;
}
