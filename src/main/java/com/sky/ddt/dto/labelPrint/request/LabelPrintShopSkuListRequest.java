package com.sky.ddt.dto.labelPrint.request;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;

/**
 * @author baixueping
 * @description 列表查询标签打印shopsku列表
 * @date 2020/2/28 15:51
 */
@Data
public class LabelPrintShopSkuListRequest extends DataGridRequest {
    Integer labelPrintId;
}
