package com.sky.ddt.dto.produceOrder.request;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author sky
 * @Description 保存成本备注
 * @date 2021/11/16 20:37
 */
@Data
public class SaveProduceOrderCostRemarkRequest {
    @NotNull(message = "id不能为空")
    Integer id;
    @Size(max = 500,message = "长度不能超过50")
    String costRemark;
}
