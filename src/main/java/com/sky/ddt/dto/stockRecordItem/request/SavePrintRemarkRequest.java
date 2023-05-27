package com.sky.ddt.dto.stockRecordItem.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author baixueping
 * @description 保存补货信息备注
 * @date 2020/4/24 15:10
 */
@Data
public class SavePrintRemarkRequest {
    @NotNull(message = "stockRecordItemId不能为空")
    Integer stockRecordItemId;
    String printRemark;
}
