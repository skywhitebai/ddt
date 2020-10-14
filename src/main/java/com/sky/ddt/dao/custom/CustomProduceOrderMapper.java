package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.ProduceOrderMapper;
import com.sky.ddt.dto.produceOrder.request.ListProduceOrderRequest;
import com.sky.ddt.dto.produceOrder.response.ListProduceOrderResponse;

import java.util.List;

/**
 * @author baixueping
 * @description 生产单操作类
 * @date 2020/3/27 11:21
 */
public interface CustomProduceOrderMapper extends ProduceOrderMapper {
    /**
     * @param
     * @return
     * @description 生产单列表查询
     * @author baixueping
     * @date 2020/3/27 11:33
     */
    List<ListProduceOrderResponse> listProduceOrder(ListProduceOrderRequest listProduceOrderRequest);
}
