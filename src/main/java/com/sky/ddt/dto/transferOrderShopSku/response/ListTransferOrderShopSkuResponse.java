package com.sky.ddt.dto.transferOrderShopSku.response;

import com.sky.ddt.entity.TransferOrderShopSku;
import lombok.Data;

/**
 * @author baixueping
 * @description 调拨单店铺sku
 * @date 2020/9/1 10:55
 */
@Data
public class ListTransferOrderShopSkuResponse extends TransferOrderShopSku {
    String shopNameFrom;
    String shopNameTo;
    String shopSkuFrom;
    String shopSkuTo;
    String sku;
    Integer inventoryQuantity;
}
