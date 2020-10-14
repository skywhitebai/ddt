package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.outboundOrder.request.SaveOutboundOrderRequest;
import com.sky.ddt.dto.outboundOrder.response.ListOutboundOrderResponse;
import com.sky.ddt.dto.outboundOrder.request.ListOutboundOrderRequest;
import com.sky.ddt.dto.response.BaseResponse;
import com.sky.ddt.entity.FbaPackingList;
import com.sky.ddt.entity.OutboundOrder;

/**
 * @author baixueping
 * @description 出库单服务
 * @date 2020/5/12 9:50
 */
public interface IOutboundOrderService {
    /**
     * @param
     * @return
     * @description 分页查询出库单信息
     * @author baixueping
     * @date 2020/5/12 10:08
     */
    PageInfo<ListOutboundOrderResponse> listOutboundOrder(ListOutboundOrderRequest params);

    /**
     * @param
     * @return
     * @description 保存出库单信息
     * @author baixueping
     * @date 2020/5/12 11:03
     */
    BaseResponse saveOutboundOrder(SaveOutboundOrderRequest params, Integer dealUserId);

    /**
     * @param
     * @return
     * @description 取消出库单
     * @author baixueping
     * @date 2020/5/12 11:22
     */
    BaseResponse cancelOutboundOrder(Integer id, Integer dealUserId);

    /**
     * @param
     * @return
     * @description 出库
     * @author baixueping
     * @date 2020/5/12 11:29
     */
    BaseResponse outbound(Integer id, Integer dealUserId);

    /**
     * @param
     * @return
     * @description 获取出库单信息
     * @author baixueping
     * @date 2020/5/12 13:11
     */
    OutboundOrder getOutboundOrderById(Integer outboundOrderId);

    /**
     * @param
     * @return
     * @description fba装箱单生成出库单
     * @author baixueping
     * @date 2020/8/4 14:42
     */
    BaseResponse generateOutboundOrder(FbaPackingList fbaPackingList, Integer dealUserId);
}
