package com.sky.ddt.dto.internalOrderNumber.request;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author baixueping
 * @description 列表查询内部单号入参
 * @date 2020/6/30 14:22
 */
@Data
public class ListInternalOrderNumberRequest extends DataGridRequest {
    String orderNumber;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date createTimeStart;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date createTimeEnd;
}
