package com.sky.ddt.dto.warehousingOrderShopSku.request;

import com.sky.ddt.common.constant.WarehousingOrderShopSkuConstant;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author baixueping
 * @description 保存入库数量
 * @date 2020/7/17 10:12
 */
@Data
public class SaveWarehousingQuantityRequest {
    @NotNull(message = WarehousingOrderShopSkuConstant.ID_EMPTY)
    Integer id;
    @NotNull(message = WarehousingOrderShopSkuConstant.WAREHOUSING_QUANTITY_EMPTY)
    @Min(value = 1, message = WarehousingOrderShopSkuConstant.WAREHOUSING_QUANTITY_ERRO)
    Integer warehousingQuantity;
}
