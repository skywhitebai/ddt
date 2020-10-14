package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.StockCartMapper;
import com.sky.ddt.dto.stock.request.ListStockRequest;
import com.sky.ddt.dto.stock.response.ListStockResponse;
import com.sky.ddt.entity.StockCart;

import java.util.List;

/**
 * @author baixueping
 * @description 备货
 * @date 2019/8/21 14:41
 */
public interface CustomStockCartMapper extends StockCartMapper {
    /**
     * @param
     * @return
     * @description 查询备货信息
     * @author baixueping
     * @date 2019/8/21 14:50
     */
    List<ListStockResponse> listStock(ListStockRequest params);
}
