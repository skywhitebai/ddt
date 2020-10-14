package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.dto.warehousingOrder.request.ListWarehousingOrderRequest;
import com.sky.ddt.dto.warehousingOrder.request.SaveWarehousingOrderRequest;
import com.sky.ddt.dto.warehousingOrder.response.ListWarehousingOrderResponse;
import com.sky.ddt.entity.WarehousingOrder;

/**
 * @author baixueping
 * @description 入库单管理
 * @date 2020/4/10 9:12
 */
public interface IWarehousingOrderService {
    /**
     * @param
     * @return
     * @description 分页查询入库单信息
     * @author baixueping
     * @date 2020/4/10 16:05
     */
    PageInfo<ListWarehousingOrderResponse> listWarehousingOrder(ListWarehousingOrderRequest listWarehousingOrderRequest);

    /**
     * @param
     * @return
     * @description 保存入库单信息
     * @author baixueping
     * @date 2020/4/17 16:44
     */
    BaseResponse saveWarehousingOrder(SaveWarehousingOrderRequest params, Integer dealUserId);

    /**
     * @param
     * @return
     * @description 废除入库单
     * @author baixueping
     * @date 2020/4/23 11:12
     */
    BaseResponse cancelWarehousingOrder(Integer id, Integer dealUserId);

    /**
     * @param
     * @return
     * @description 根据入库单id获取入库单
     * @author baixueping
     * @date 2020/4/24 10:06
     */
    WarehousingOrder getWarehousingOrderById(Integer warehousingOrderId);

    /**
     * @param
     * @return
     * @description 入库操作
     * @author baixueping
     * @date 2020/5/7 10:49
     */
    BaseResponse warehousing(Integer id, Integer dealUserId);

    /**
     * @param
     * @return
     * @description 判断是否存在待入库订单数量
     * @author baixueping
     * @date 2020/5/8 16:31
     */
    boolean existPendingStoragewarehousingOrder(Integer produceOrderId);
}
