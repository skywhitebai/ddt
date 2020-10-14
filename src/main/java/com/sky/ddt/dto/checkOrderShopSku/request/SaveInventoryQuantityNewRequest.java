package com.sky.ddt.dto.checkOrderShopSku.request;

import com.sky.ddt.common.constant.CheckOrderShopSkuConstant;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author baixueping
 * @description 保存最新库存数量
 * @date 2020/7/17 11:04
 */
@Data
public class SaveInventoryQuantityNewRequest {
    @NotNull(message = CheckOrderShopSkuConstant.ID_EMPTY)
    Integer id;
    @NotNull(message = CheckOrderShopSkuConstant.INVENTORY_QUANTITY_NEW_EMPTY)
    @Min(value = 1, message = CheckOrderShopSkuConstant.INVENTORY_QUANTITY_NEW_ERRO)
    Integer inventoryQuantityNew;
}
