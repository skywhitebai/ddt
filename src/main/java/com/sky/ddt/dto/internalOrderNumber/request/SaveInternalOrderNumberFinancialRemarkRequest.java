package com.sky.ddt.dto.internalOrderNumber.request;

import com.sky.ddt.common.constant.InternalOrderNumberConstant;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author baixueping
 * @description 保存内部单号
 * @date 2020/6/30 15:06
 */
@Data
public class SaveInternalOrderNumberFinancialRemarkRequest {
    @NotNull(message =InternalOrderNumberConstant.ID_EMPTY )
    Integer id;
    @NotNull(message = InternalOrderNumberConstant.NUMBER_EMPTY)
    @Length(max = 200, message = InternalOrderNumberConstant.FINANCIAL_REMARK_TOO_LONG)
    String financialRemark;
}
