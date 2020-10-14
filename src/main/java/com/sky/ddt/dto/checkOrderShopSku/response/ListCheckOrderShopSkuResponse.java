package com.sky.ddt.dto.checkOrderShopSku.response;

import com.sky.ddt.entity.CheckOrderShopSku;
import lombok.Data;

/**
 * @author baixueping
 * @description 查询盘点单店铺sku返回值
 * @date 2020/5/11 14:53
 */
@Data
public class ListCheckOrderShopSkuResponse extends CheckOrderShopSku{
    String shopName;
    String sku;
}
