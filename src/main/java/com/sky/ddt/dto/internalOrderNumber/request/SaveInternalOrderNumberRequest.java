package com.sky.ddt.dto.internalOrderNumber.request;

import com.sky.ddt.common.constant.InternalOrderNumberConstant;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author baixueping
 * @description 保存内部单号
 * @date 2020/6/30 15:06
 */
@Data
public class SaveInternalOrderNumberRequest {
    Integer id;
    @NotNull(message = InternalOrderNumberConstant.NUMBER_EMPTY)
    @Min(value = 1, message = InternalOrderNumberConstant.NUMBER_ERRO)
    Integer number;
    @NotNull(message = InternalOrderNumberConstant.TRANSPORT_TYPE_ID_EMPTY)
    Integer transportTypeId;
    @Length(max = 200, message = InternalOrderNumberConstant.REMARK_TOO_LONG)
    String remark;
    @Length(max = 200, message = InternalOrderNumberConstant.FINANCIAL_REMARK_TOO_LONG)
    String financialRemark;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date estimatedArrivalTime;
}
