package com.sky.ddt.dto.stockRecord.response;

import com.sky.ddt.entity.StockRecord;
import lombok.Data;

/**
 * @author baixueping
 * @description 备货
 * @date 2019/8/22 18:05
 */
@Data
public class ListStockRecordResponse extends StockRecord {
    String shopName;
    Integer stockQuantityTotal;
}
