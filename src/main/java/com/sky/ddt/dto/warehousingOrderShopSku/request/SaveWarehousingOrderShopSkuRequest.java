package com.sky.ddt.dto.warehousingOrderShopSku.request;

import com.sky.ddt.common.constant.WarehousingOrderConstant;
import com.sky.ddt.common.constant.WarehousingOrderShopSkuConstant;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author baixueping
 * @description 保存入库单店铺sku信息
 * @date 2020/4/24 9:35
 */
@Data
public class SaveWarehousingOrderShopSkuRequest {
    Integer id;
    @NotNull(message = WarehousingOrderShopSkuConstant.WAREHOUSING_ORDER_ID_EMPTY)
    Integer warehousingOrderId;
    @NotBlank(message = WarehousingOrderShopSkuConstant.SHOP_SKU_EMPTY)
    String shopSku;
    @NotNull(message = WarehousingOrderShopSkuConstant.WAREHOUSING_QUANTITY_EMPTY)
    @Min(value = 1, message = WarehousingOrderShopSkuConstant.WAREHOUSING_QUANTITY_ERRO)
    Integer warehousingQuantity;
    @Length(max = 200, message = WarehousingOrderShopSkuConstant.REMARK_TOO_LONG)
    String remark;
}
