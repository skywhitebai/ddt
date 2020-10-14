package com.sky.ddt.dto.finance.request;

import com.sky.ddt.common.constant.FinanceConstant;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @author baixueping
 * @description 保存财务备注
 * @date 2020/1/3 11:09
 */
@Data
public class SaveFinanceRemarkRequest {
    @NotNull(message = FinanceConstant.FINANCE_ID_EMPTY)
    Integer financeId;
    @Length(max = 500,message =FinanceConstant.REMARK_TOO_LONG )
    String remark;
}
