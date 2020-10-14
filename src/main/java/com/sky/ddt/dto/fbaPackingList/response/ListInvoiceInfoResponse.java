package com.sky.ddt.dto.fbaPackingList.response;

import lombok.Data;

/**
 * @author baixueping
 * @description 列表查询发票信息
 * @date 2020/7/23 14:54
 */
@Data
public class ListInvoiceInfoResponse {
    Integer fbaPackingListId;
    Integer internalOrderNumberId;
    String orderNumber;
    String transportTypeName;
    Integer fbaShipmentIdCount;
    Integer shopSkuCount;
    Integer shopSkuQuantity;
}
