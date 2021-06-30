package com.sky.ddt.dto.amazon.amazonFbaInventory.request;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;

/**
 * @author baixueping
 * @description 列表查询亚马逊库存
 * @date 2021/6/29 16:20
 */
@Data
public class ListAmazonFbaInventoryRequest extends DataGridRequest {
    private String merchantId;
    private String asin;
    private String fnSku;
    private String sellerSku;
    private String productName;
}
