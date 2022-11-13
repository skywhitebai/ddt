package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.stock.request.ListSendQuntityReq;
import com.sky.ddt.dto.stock.request.ListStockRequest;
import com.sky.ddt.dto.stock.request.SaveProductionQuantityRequest;
import com.sky.ddt.dto.stock.request.SaveStockQuantityRequest;
import com.sky.ddt.dto.stock.response.ListSendQuantityResp;
import com.sky.ddt.dto.stock.response.ListStockResponse;

import java.util.List;

/**
 * @author baixueping
 * @description 备货购物车服务
 * @date 2019/8/21 8:47
 */
public interface IStockCartService {
    /**
     * @param
     * @return
     * @description 查询备货信息
     * @author baixueping
     * @date 2019/8/21 12:33
     */
    PageInfo<ListStockResponse> listStock(ListStockRequest params);

    /**
     * @param
     * @return
     * @description 保存补货数据
     * @author baixueping
     * @date 2019/8/22 14:58
     */
    BaseResponse saveStockQuantity(SaveStockQuantityRequest params, Integer currentUserId);

    /**
     * @param
     * @return
     * @description 保存生产数量
     * @author baixueping
     * @date 2019/9/3 10:36
     */
    BaseResponse saveProductionQuantity(SaveProductionQuantityRequest params, Integer currentUserId);

    PageInfo<ListStockResponse> listWarehouseStock(ListStockRequest params);

    PageInfo<ListSendQuantityResp> listSendQuantity(ListSendQuntityReq params);

    List<ListStockResponse> listExportStock(ListStockRequest params);
}
