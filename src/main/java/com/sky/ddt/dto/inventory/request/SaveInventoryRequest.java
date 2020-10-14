package com.sky.ddt.dto.inventory.request;

import lombok.Data;

/**
 * @author baixueping
 * @description 保存库存入参
 * @date 2019/4/22 19:13
 */
@Data
public class SaveInventoryRequest {
    private String sellerSku;

    private String fnSku;

    private String asin;

    private String condition;

    private Integer totalSupplyQuantity;

    private Integer inStockSupplyQuantity;

    private TimepointRequest earliestAvailability;
}
