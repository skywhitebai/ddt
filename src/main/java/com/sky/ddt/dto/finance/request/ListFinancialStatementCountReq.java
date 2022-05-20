package com.sky.ddt.dto.finance.request;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

/**
 * @author sky
 * @Description 列表查询财务汇总信息
 * @date 2022/5/19 22:02
 */
@Data
public class ListFinancialStatementCountReq {
    @NotEmpty(message = "类型不能为空")
    String type;
    @NotEmpty(message = "月份不能为空")
    String month;
    Date monthDate;
}
