package com.sky.ddt.dto.stockRecord.request;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;

/**
 * @author baixueping
 * @description 备货记录
 * @date 2019/8/22 18:03
 */
@Data
public class ListStockRecordRequest extends DataGridRequest {
    Integer shopId;
    Integer userId;
    Integer id;
    String shopSku;
    String sku;
    Integer status;
}
