package com.sky.ddt.dto.costCalculation.request;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @author sky
 * @Description
 * @date 2021/11/18 0:24
 */
@Data
public class SaveCostCalculationRemarkRequest {
    @NotNull(message = "id不能为空")
    Integer id;
    @Length(max = 200,message = "长度不能超过200")
    String remark;
}
