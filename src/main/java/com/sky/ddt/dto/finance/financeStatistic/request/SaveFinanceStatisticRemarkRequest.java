package com.sky.ddt.dto.finance.financeStatistic.request;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author baixueping
 * @description SaveManualAdjustmentRequest
 * @date 2021/7/6 22:24
 */
@Data
public class SaveFinanceStatisticRemarkRequest {
    @Length(max = 100,message = "备注长度不能超过100")
    String remark;
    @NotNull(message = "id不能为空")
    Integer id;
}
