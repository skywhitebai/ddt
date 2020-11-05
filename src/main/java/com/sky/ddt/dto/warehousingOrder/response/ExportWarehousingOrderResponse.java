package com.sky.ddt.dto.warehousingOrder.response;

import com.sky.ddt.entity.WarehousingOrder;
import lombok.Data;

import java.util.Date;

/**
 * @author baixueping
 * @description 列表查询入库单信息返回值
 * @date 2020/4/10 15:40
 */
@Data
public class ExportWarehousingOrderResponse{
    String shopName;
    Date createTime;
    Date warehousingTime;
    Integer type;
    String typeName;
    Integer status;
    String statusName;
    String produceOrderBatchNumber;
    String batchNumber;
    String sku;
    String shopSku;
    Integer warehousingquantity;
}
