package com.sky.ddt.dto.finance.financeStatistic.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author baixueping
 * @description SaveManualAdjustmentRequest
 * @date 2021/7/6 22:24
 */
@Data
public class SaveFinanceStatisticManualAdjustmentRequest {
    @NotNull(message = "账外调整不能为空")
    BigDecimal manualAdjustment;
    @NotNull(message = "id不能为空")
    Integer id;
}
