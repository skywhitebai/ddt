package com.sky.ddt.dto.deliverGoods.request;

import lombok.Data;

/**
 * @author baixueping
 * @description 仓库装箱单
 * @date 2019/9/11 8:56
 */
@Data
public class WarehousePackingInfo {
    String shopSku;
    String sku;
    String quantity;
}
