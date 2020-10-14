package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.OutboundOrderMapper;
import com.sky.ddt.dto.outboundOrder.response.ListOutboundOrderResponse;
import com.sky.ddt.dto.outboundOrder.request.ListOutboundOrderRequest;

import java.util.List;

/**
 * @author baixueping
 * @description 出库单操作类
 * @date 2020/5/12 9:54
 */
public interface CustomOutboundOrderMapper extends OutboundOrderMapper{
    /**
     * @param
     * @return
     * @description 查询出库单信息
     * @author baixueping
     * @date 2020/5/12 10:12
    */
    List<ListOutboundOrderResponse> listOutboundOrder(ListOutboundOrderRequest params);
}
