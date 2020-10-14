package com.sky.ddt.dto.fbaImport.request;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;

/**
 * @author baixueping
 * @description 列表查询fba导入
 * @date 2019/8/15 12:55
 */
@Data
public class ListFbaImportRequest extends DataGridRequest{
    Integer shopId;
    String sku;
    String fnsku;
    String asin;
    Integer userId;
}
