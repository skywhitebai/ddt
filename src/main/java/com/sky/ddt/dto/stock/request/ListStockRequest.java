package com.sky.ddt.dto.stock.request;

import com.sky.ddt.common.constant.StockConsatnt;
import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author baixueping
 * @description 备货信息查询参数
 * @date 2019/8/21 11:21
 */
@Data
public class ListStockRequest extends DataGridRequest {
    @NotNull(message = StockConsatnt.SHOP_ID_EMPTY)
    Integer shopId;
    String shopSku;
    String sku;
    String shopParentSku;
    Integer showType;
    Integer salesmanUserId;
    Integer userId;
    Integer produceStatus;
}
