package com.sky.ddt.dto.inventoryChangeRecord.request;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author baixueping
 * @description 列表查询库存变更记录
 * @date 2020/5/12 17:48
 */
@Data
public class ListInventoryChangeRecordRequest extends DataGridRequest {
    Integer shopId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date createTimeStart;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date createTimeEnd;
    String shopSku;
    Integer createBy;
}
