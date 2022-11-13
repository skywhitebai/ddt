package com.sky.ddt.dto.amazonReservedInventory.req;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;

/**
 * @author sky
 * @Description
 * @date 2022/11/7 21:14
 */
@Data
public class ListAmazonReservedInventoryReq extends DataGridRequest {
    Integer shopId;
    String sku;
    String fnsku;
    String asin;
    Integer shopSkuId;
}
