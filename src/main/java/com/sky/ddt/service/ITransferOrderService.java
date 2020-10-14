package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.transferOrder.request.ListTransferOrderRequest;
import com.sky.ddt.dto.transferOrder.request.SaveTransferOrderRequest;
import com.sky.ddt.dto.transferOrder.response.ListTransferOrderResponse;
import com.sky.ddt.entity.TransferOrder;

/**
 * @author baixueping
 * @description 调拨单服务
 * @date 2020/8/28 16:21
 */
public interface ITransferOrderService {
    /**
     * @param
     * @return
     * @description 分页查询调拨单信息
     * @author baixueping
     * @date 2020/8/31 17:27
     */
    PageInfo<ListTransferOrderResponse> listTransferOrder(ListTransferOrderRequest params);

    /**
     * @param
     * @return
     * @description 保存调拨单
     * @author baixueping
     * @date 2020/8/31 19:08
     */
    BaseResponse saveTransferOrder(SaveTransferOrderRequest params, Integer dealUserId);

    TransferOrder getTransferOrderById(Integer transferOrderId);

    BaseResponse cancelTransferOrder(Integer id, Integer dealUserId);

    /**
     * @param
     * @return
     * @description 调拨
     * @author baixueping
     * @date 2020/9/1 14:55
     */
    BaseResponse transfer(Integer id, Integer dealUserId);
}
