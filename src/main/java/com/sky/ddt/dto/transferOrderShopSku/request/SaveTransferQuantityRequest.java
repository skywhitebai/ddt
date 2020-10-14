package com.sky.ddt.dto.transferOrderShopSku.request;

import com.sky.ddt.common.constant.TransferOrderShopSkuConstant;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author baixueping
 * @description 
 * @date 2020/9/1 17:40
 */
@Data
public class SaveTransferQuantityRequest {
    @NotNull(message = TransferOrderShopSkuConstant.ID_EMPTY)
    Integer id;
    @NotNull(message = TransferOrderShopSkuConstant.TRANSFER_QUANTITY_EMPTY)
    @Min(value = 1, message = TransferOrderShopSkuConstant.TRANSFER_QUANTITY_ERRO)
    Integer transferQuantity;
}
