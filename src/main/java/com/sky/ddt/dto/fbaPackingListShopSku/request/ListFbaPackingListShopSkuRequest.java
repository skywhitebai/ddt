package com.sky.ddt.dto.fbaPackingListShopSku.request;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;

/**
 * @author baixueping
 * @description 分页查询fba装箱单店铺sku入参
 * @date 2020/7/23 10:39
 */
@Data
public class ListFbaPackingListShopSkuRequest extends DataGridRequest {
    Integer fbaPackingListId;
    String shopSku;
}
