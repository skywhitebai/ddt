package com.sky.ddt.dto.sku.response;

import com.sky.ddt.entity.Sku;
import lombok.Data;

/**
 * @author baixueping
 * @description sku列表返回值
 * @date 2019/5/10 9:18
 */
@Data
public class SkuListResponse extends Sku {
    String productProductName;
    String productCode;
    String imgUrl;
    Integer inventoryQuantity;
}
