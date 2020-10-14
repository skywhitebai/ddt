package com.sky.ddt.dto.produceOrderShopSku.request;

import com.sky.ddt.common.constant.ProduceOrderConstant;
import com.sky.ddt.common.constant.ProduceOrderShopSkuConstant;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author baixueping
 * @description 保存生产单店铺sku
 * @date 2020/4/2 10:59
 */
@Data
public class SaveProduceOrderShopSkuRequest {
    Integer id;
    @NotNull(message = ProduceOrderShopSkuConstant.PRODUCE_ORDER_ID_EMPTY)
    Integer produceOrderId;
    @NotBlank(message = ProduceOrderShopSkuConstant.SHOP_SKU_EMPTY)
    String shopSku;
    @NotNull(message = ProduceOrderShopSkuConstant.PRODUCTION_QUANTITY_EMPTY)
    @Min(value = 1, message = ProduceOrderShopSkuConstant.PRODUCTION_QUANTITY_ERRO)
    Integer productionQuantity;
    @Length(max = ProduceOrderShopSkuConstant.REMARK_LENGTH, message = ProduceOrderShopSkuConstant.REMARK_TOO_LONG)
    String remark;
}
