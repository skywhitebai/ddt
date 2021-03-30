package com.sky.ddt.dto.produceOrderShopSku.request;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author baixueping
 * @description 列表查询其他生产单生产中数量
 * @date 2021/3/30 16:14
 */
@Data
public class ListProduceOrderShopSkuProductionQuantityRequest  extends DataGridRequest {
    @NotNull(message = "店铺id不能为空")
    Integer shopId;
    @NotNull(message = "产品skuId不能为空")
    Integer skuId;
    @NotNull(message = "店铺类型不能为空")
    Integer type;
}
