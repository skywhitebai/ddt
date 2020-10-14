package com.sky.ddt.dto.outboundOrderShopSku.request;

import com.sky.ddt.common.constant.OutboundOrderShopSkuConstant;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author baixueping
 * @description 保存出库单店铺sku
 * @date 2020/5/12 13:00
 */
@Data
public class SaveOutboundOrderShopSkuRequest {

    Integer id;
    @NotNull(message = OutboundOrderShopSkuConstant.OUTBOUND_ORDER_ID_EMPTY)
    Integer outboundOrderId;
    @NotBlank(message = OutboundOrderShopSkuConstant.SHOP_SKU_EMPTY)
    String shopSku;
    @NotNull(message = OutboundOrderShopSkuConstant.OUTBOUND_QUANTITY_EMPTY)
    @Min(value = 1, message = OutboundOrderShopSkuConstant.OUTBOUND_QUANTITY_ERRO)
    Integer outboundQuantity;
    @Length(max = 200, message = OutboundOrderShopSkuConstant.REMARK_TOO_LONG)
    String remark;
}
