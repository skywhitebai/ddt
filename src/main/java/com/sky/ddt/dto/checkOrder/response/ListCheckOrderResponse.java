package com.sky.ddt.dto.checkOrder.response;

import com.sky.ddt.entity.CheckOrder;
import lombok.Data;

/**
 * @author baixueping
 * @description 列表查询盘点单返回值
 * @date 2020/5/9 17:34
 */
@Data
public class ListCheckOrderResponse extends CheckOrder {
    String shopName;
    String statusName;
    Integer inventoryQuantityNewTotal;
}
