package com.sky.ddt.dto.deliverGoods.request;

import lombok.Data;

/**
 * @author baixueping
 * @description 发货计划
 * @date 2019/9/9 16:46
 */
@Data
public class DeliverPlanRequest {
    String shopSku;
    Integer quantity;
}
