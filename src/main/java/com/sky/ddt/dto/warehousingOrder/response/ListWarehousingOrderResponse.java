package com.sky.ddt.dto.warehousingOrder.response;

import com.sky.ddt.entity.WarehousingOrder;
import lombok.Data;

/**
 * @author baixueping
 * @description 列表查询入库单信息返回值
 * @date 2020/4/10 15:40
 */
@Data
public class ListWarehousingOrderResponse extends WarehousingOrder{
    String shopName;
    String statusName;
    String typeName;
    String produceOrderBatchNumber;
    Integer warehousingQuantityTotal;
}
