package com.sky.ddt.dto.outboundOrderShopSku.request;

import com.sky.ddt.common.constant.OutboundOrderShopSkuConstant;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author baixueping
 * @description 保存出库数量
 * @date 2020/7/17 11:13
 */
@Data
public class SaveOutboundQuantityRequest {

    @NotNull(message = OutboundOrderShopSkuConstant.ID_EMPTY)
    Integer id;
    @NotNull(message = OutboundOrderShopSkuConstant.OUTBOUND_QUANTITY_EMPTY)
    @Min(value = 1, message = OutboundOrderShopSkuConstant.OUTBOUND_QUANTITY_ERRO)
    Integer outboundQuantity;
}
