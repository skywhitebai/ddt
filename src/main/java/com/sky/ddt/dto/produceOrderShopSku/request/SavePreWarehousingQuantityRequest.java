package com.sky.ddt.dto.produceOrderShopSku.request;

import com.sky.ddt.common.constant.ProduceOrderShopSkuConstant;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author baixueping
 * @description 保存生产数量
 * @date 2020/7/9 12:48
 */
@Data
public class SavePreWarehousingQuantityRequest {
    @NotNull(message = ProduceOrderShopSkuConstant.ID_EMPTY)
    Integer id;
    @NotNull(message = ProduceOrderShopSkuConstant.PRE_WAREHOUSING_QUANTITY_EMPTY)
    @Min(value = 1, message = ProduceOrderShopSkuConstant.PRE_WAREHOUSING_QUANTITY_ERRO)
    Integer preWarehousingQuantity;
}
