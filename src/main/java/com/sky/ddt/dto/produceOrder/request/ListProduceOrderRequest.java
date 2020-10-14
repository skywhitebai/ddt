package com.sky.ddt.dto.produceOrder.request;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author baixueping
 * @description 列表查询生产单入参
 * @date 2020/3/26 17:02
 */
@Data
public class ListProduceOrderRequest extends DataGridRequest{
    Integer shopId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date productionTimeStart;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date productionTimeEnd;
    String batchNumber;
    String shopSku;
    Integer status;
}
