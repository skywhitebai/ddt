package com.sky.ddt.dto.produceOrder.response;

import com.sky.ddt.entity.ProduceOrder;
import lombok.Data;

/**
 * @author baixueping
 * @description 生产单列表
 * @date 2020/3/27 10:50
 */
@Data
public class ListProduceOrderResponse extends ProduceOrder {
    String shopName;
    String statusName;
    Integer productionQuantityTotal;
}
