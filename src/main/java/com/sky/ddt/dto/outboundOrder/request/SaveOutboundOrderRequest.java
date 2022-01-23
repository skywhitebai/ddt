package com.sky.ddt.dto.outboundOrder.request;

import com.sky.ddt.common.constant.CheckOrderConstant;
import com.sky.ddt.common.constant.OutboundOrderConstant;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @author baixueping
 * @description 保存出库单入参
 * @date 2020/5/12 10:57
 */
@Data
public class SaveOutboundOrderRequest {
    Integer id;
    Integer outboundShopId;
    @NotNull(message = OutboundOrderConstant.SHOP_ID_EMPTY)
    Integer shopId;
    @Length(max = 50, message = OutboundOrderConstant.FBA_NO_TOO_LONG)
    String fbaNo;
    @Length(max = 200, message = OutboundOrderConstant.REMARK_TOO_LONG)
    String remark;
}
