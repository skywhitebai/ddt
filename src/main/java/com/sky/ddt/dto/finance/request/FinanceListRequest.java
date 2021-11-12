package com.sky.ddt.dto.finance.request;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;

import java.util.Date;

/**
 * @author baixueping
 * @description   财务分页查询参数
 * @date 2019/11/20 16:11
 */
@Data
public class FinanceListRequest extends DataGridRequest {
    Integer shopId;
    String month;
    Date monthDate;
    Integer currentUserId;
}