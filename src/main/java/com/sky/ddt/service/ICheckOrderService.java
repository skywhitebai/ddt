package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.checkOrder.request.ListCheckOrderRequest;
import com.sky.ddt.dto.checkOrder.request.SaveCheckOrderRequest;
import com.sky.ddt.dto.checkOrder.response.ListCheckOrderResponse;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.CheckOrder;

/**
 * @author baixueping
 * @description 盘点单
 * @date 2020/5/9 10:51
 */
public interface ICheckOrderService {
    /**
     * @param
     * @return
     * @description 分页查询入库单列表
     * @author baixueping
     * @date 2020/5/9 17:37
     */
    PageInfo<ListCheckOrderResponse> listCheckOrder(ListCheckOrderRequest params);

    /**
     * @param
     * @return
     * @description 保存盘点单
     * @author baixueping
     * @date 2020/5/11 10:19
     */
    BaseResponse saveCheckOrder(SaveCheckOrderRequest params, Integer dealUserId);

    /**
     * @param
     * @return
     * @description 取消盘点单
     * @author baixueping
     * @date 2020/5/11 11:24
     */
    BaseResponse cancelCheckOrder(Integer id, Integer dealUserId);

    /**
     * @param
     * @return
     * @description 盘点单确认
     * @author baixueping
     * @date 2020/5/11 11:28
     */
    BaseResponse confirmCheckOrder(Integer id, Integer dealUserId);

    /**
     * @param
     * @return
     * @description 根据id获取盘点单信息
     * @author baixueping
     * @date 2020/5/11 15:28
     */
    CheckOrder getCheckOrderById(Integer checkOrderId);
}
