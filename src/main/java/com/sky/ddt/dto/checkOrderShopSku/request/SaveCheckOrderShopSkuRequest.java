package com.sky.ddt.dto.checkOrderShopSku.request;

import com.sky.ddt.common.constant.CheckOrderShopSkuConstant;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author baixueping
 * @description 保存盘点单店铺sku
 * @date 2020/5/11 15:18
 */
@Data
public class SaveCheckOrderShopSkuRequest {
    Integer id;
    @NotNull(message = CheckOrderShopSkuConstant.CHECK_ORDER_ID_EMPTY)
    Integer checkOrderId;
    @NotBlank(message = CheckOrderShopSkuConstant.SHOP_SKU_EMPTY)
    String shopSku;
    @NotNull(message = CheckOrderShopSkuConstant.INVENTORY_QUANTITY_NEW_EMPTY)
    @Min(value = 0, message = CheckOrderShopSkuConstant.INVENTORY_QUANTITY_NEW_ERRO)
    Integer inventoryQuantityNew;
    @Length(max = 200, message = CheckOrderShopSkuConstant.REMARK_TOO_LONG)
    String remark;
}
