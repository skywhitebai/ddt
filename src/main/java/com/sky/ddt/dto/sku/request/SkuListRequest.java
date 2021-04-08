package com.sky.ddt.dto.sku.request;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author baixueping
 * @description sku列表查询
 * @date 2019/5/10 9:14
 */
@Data
public class SkuListRequest extends DataGridRequest {
    String sku;
    String productCode;
    String productName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date createTimeStart;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date createTimeEnd;
}
