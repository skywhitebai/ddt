package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.stockRecordItem.request.ListStockRecordItemRequest;
import com.sky.ddt.dto.stockRecordItem.response.ListStockRecordItemResponse;

/**
 * @author baixueping
 * @description 备货内容
 * @date 2019/8/21 8:50
 */
public interface IStockRecordItemService {
    /**
     * @param
     * @return 
     * @description 发货单明细查询
     * @author baixueping
     * @date 2019/8/23 10:35
    */
    PageInfo<ListStockRecordItemResponse> listStockRecordItem(ListStockRecordItemRequest params);
}
