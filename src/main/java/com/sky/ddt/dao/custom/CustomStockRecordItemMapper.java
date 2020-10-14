package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.StockRecordItemMapper;
import com.sky.ddt.dto.stockRecord.request.ListStockRecordRequest;
import com.sky.ddt.dto.stockRecord.response.ListStockRecordResponse;
import com.sky.ddt.dto.stockRecordItem.request.ListStockRecordItemRequest;
import com.sky.ddt.dto.stockRecordItem.response.ListStockRecordItemResponse;

import java.util.List;

/**
 * @author baixueping
 * @description 备货记录明细
 * @date 2019/8/22 17:04
 */
public interface CustomStockRecordItemMapper extends StockRecordItemMapper {
    /**
     * @param
     * @return
     * @description 查询发货单详情
     * @author baixueping
     * @date 2019/8/23 10:37
    */
    List<ListStockRecordItemResponse> listStockRecordItem(ListStockRecordItemRequest params);
}
