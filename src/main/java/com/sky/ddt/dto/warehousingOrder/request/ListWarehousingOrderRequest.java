package com.sky.ddt.dto.warehousingOrder.request;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author baixueping
 * @description 列表查询入库单
 * @date 2020/4/10 15:35
 */
@Data
public class ListWarehousingOrderRequest extends DataGridRequest {
    Integer shopId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date warehousingTimeStart;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date warehousingTimeEnd;
    String batchNumber;
    String shopSku;
    Integer type;
    String produceOrderBatchNumber;
    Integer status;
}
