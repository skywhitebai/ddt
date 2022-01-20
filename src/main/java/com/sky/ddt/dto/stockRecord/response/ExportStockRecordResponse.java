package com.sky.ddt.dto.stockRecord.response;

import lombok.Data;

/**
 * @author baixueping
 * @description 补货信息导出
 * @date 2019/8/23 11:10
 */
@Data
public class ExportStockRecordResponse {
    String shopName;
    Integer stockRecordId;
    String locationNos;
    String shopSku;
    String sku;
    String fnsku;
    Integer stockQuantity;
}
