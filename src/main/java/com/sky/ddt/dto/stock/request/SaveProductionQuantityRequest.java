package com.sky.ddt.dto.stock.request;

import com.sky.ddt.common.constant.StockConsatnt;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author baixueping
 * @description 保存数量
 * @date 2019/8/22 14:50
 */
@Data
public class SaveProductionQuantityRequest {
    @NotNull(message = StockConsatnt.SHOP_SKU_ID_EMPTY)
    Integer shopSkuId;
    @NotNull(message = StockConsatnt.PRODUCTION_QUANTITY_ERRO)
    @Min(value = 0,message =StockConsatnt.PRODUCTION_QUANTITY_ERRO )
    Integer productionQuantity;
}
