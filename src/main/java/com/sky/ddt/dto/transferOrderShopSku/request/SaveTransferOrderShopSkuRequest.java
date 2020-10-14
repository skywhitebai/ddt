package com.sky.ddt.dto.transferOrderShopSku.request;

import com.sky.ddt.common.constant.TransferOrderShopSkuConstant;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author baixueping
 * @description 保存调拨单
 * @date 2020/9/1 12:45
 */
@Data
public class SaveTransferOrderShopSkuRequest {
    Integer id;
    @NotNull(message = TransferOrderShopSkuConstant.TRANSFER_ORDER_ID_EMPTY)
    Integer transferOrderId;
    @NotBlank(message = TransferOrderShopSkuConstant.SHOP_SKU_FROM_EMPTY)
    String shopSkuFrom;
    @NotBlank(message = TransferOrderShopSkuConstant.SHOP_SKU_TO_EMPTY)
    String shopSkuTo;
    @NotNull(message = TransferOrderShopSkuConstant.TRANSFER_QUANTITY_EMPTY)
    @Min(value = 1, message = TransferOrderShopSkuConstant.TRANSFER_QUANTITY_ERRO)
    Integer transferQuantity;
    @Length(max = 200, message = TransferOrderShopSkuConstant.REMARK_TOO_LONG)
    String remark;
}
