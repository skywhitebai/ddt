package com.sky.ddt.dto.internalOrderNumber.request;

import com.sky.ddt.common.annotation.NotLessThanZero;
import com.sky.ddt.common.constant.InternalOrderNumberConstant;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author baixueping
 * @description 保存内部单号
 * @date 2020/6/30 15:06
 */
@Data
public class SaveInternalOrderNumberPayAmountRequest {
    @NotNull(message = InternalOrderNumberConstant.ID_EMPTY)
    Integer id;
    @NotNull(message = InternalOrderNumberConstant.PAY_AMOUNT_NULL)
    @DecimalMin(value = "0.01", message = InternalOrderNumberConstant.PAY_AMOUNT_ERRO)
    @Digits(integer = 10,fraction = 2,message = InternalOrderNumberConstant.PAY_AMOUNT_ERRO)
    BigDecimal payAmount;
}
