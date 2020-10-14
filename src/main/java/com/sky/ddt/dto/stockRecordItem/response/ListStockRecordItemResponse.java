package com.sky.ddt.dto.stockRecordItem.response;

import com.sky.ddt.entity.StockRecordItem;
import lombok.Data;

/**
 * @author baixueping
 * @description 发货单明细表
 * @date 2019/8/23 10:25
 */
@Data
public class ListStockRecordItemResponse extends StockRecordItem {
    String shopSku;
    String salesmanRealName;
    String sku;
    String imgUrl;
    Integer skuId;
}
