package com.sky.ddt.dto.finance.request;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

/**
 * @author sky
 * @Description 查询财务信息
 * @date 2022/5/19 22:02
 */
@Data
public class ListFinancialStatementReq {
    Date month;
    Integer developerUserId;
    Integer salesmanUserId;
    Integer salesGroupUserId;
    Integer currentUserId;
    Integer financeId;
}
