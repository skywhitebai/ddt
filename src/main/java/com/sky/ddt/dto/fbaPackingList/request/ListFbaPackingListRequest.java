package com.sky.ddt.dto.fbaPackingList.request;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;

/**
 * @author baixueping
 * @description fba装箱单管理
 * @date 2020/7/22 11:02
 */
@Data
public class ListFbaPackingListRequest extends DataGridRequest {
    Integer shopId;
    String shopSku;
    String shipmentId;
    Integer userId;
}
