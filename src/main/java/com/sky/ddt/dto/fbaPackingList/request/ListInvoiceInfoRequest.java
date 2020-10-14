package com.sky.ddt.dto.fbaPackingList.request;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;

/**
 * @author baixueping
 * @description 列表查询发票信息
 * @date 2020/7/23 14:53
 */
@Data
public class ListInvoiceInfoRequest extends DataGridRequest {
    Integer fbaPackingListId;
    String orderNumber;
}