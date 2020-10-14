package com.sky.ddt.dto.orderImport.request;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author baixueping
 * @description 列表查询导入订单
 * @date 2019/8/14 12:40
 */
@Data
public class ListOrderImportRequest extends DataGridRequest {
    Integer shopId;
    String amazonOrderId;
    String sku;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date purchaseDateStart;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date purchaseDateEnd;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date lastUpdateDateStart;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date lastUpdateDateEnd;
    String orderStatus;
    Integer userId;

}
