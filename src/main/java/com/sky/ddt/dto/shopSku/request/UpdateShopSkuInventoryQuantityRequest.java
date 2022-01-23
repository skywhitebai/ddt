package com.sky.ddt.dto.shopSku.request;

import com.sky.ddt.common.constant.InventoryChangeRecordConstant;
import com.sky.ddt.entity.ShopSku;
import lombok.Data;

/**
 * @author baixueping
 * @description 修改店铺sku库存入参
 * @date 2020/5/7 16:47
 */
@Data
public class UpdateShopSkuInventoryQuantityRequest {
    Integer quantity;
    InventoryChangeRecordConstant.ChangeTypeEnum changeTypeEnum;
    Integer shopSkuId;
    Integer dealUserId;
    Integer entityId;
    Integer mainEntityId;
    ShopSku shopSkuInfo;

}
