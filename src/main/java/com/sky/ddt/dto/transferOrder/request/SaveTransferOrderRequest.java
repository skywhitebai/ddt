package com.sky.ddt.dto.transferOrder.request;

import com.sky.ddt.common.constant.TransferOrderConstant;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @author baixueping
 * @description 保存调拨单
 * @date 2020/8/31 18:23
 */
@Data
public class SaveTransferOrderRequest {
    Integer id;
    @NotNull(message = TransferOrderConstant.SHOP_ID_FROM_EMPTY)
    Integer shopIdFrom;
    @NotNull(message = TransferOrderConstant.SHOP_ID_TO_EMPTY)
    Integer shopIdTo;
    @Length(max = 200, message = TransferOrderConstant.REMARK_TOO_LONG)
    String remark;
}
