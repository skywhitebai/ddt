package com.sky.ddt.dto.produceOrder.request;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

/**
 * @author sky
 * @Description 成本耳栓
 * @date 2021/11/16 21:05
 */
@Data
public class GenerationCostRequest {
    @NotEmpty(message = "月份不能为空")
    String month;
    Date monthDate;
}
