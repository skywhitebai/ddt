package com.sky.ddt.dto.shopSku.request;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;

/**
 * @author baixueping
 * @description 店铺sku列表
 * @date 2019/7/29 15:10
 */
@Data
public class ListShopSkuRequest extends DataGridRequest {
    Integer shopId;
    String shopSku;
    String shopParentSku;
    String productCode;
    String asin;
    String parentAsin;
    String sku;
    String productName;
    Integer userId;
    Integer status;
}
