package com.sky.ddt.dto.stockRecord.request;

import lombok.Data;

/**
 * @author baixueping
 * @description 保存补货信息备注
 * @date 2020/4/24 15:10
 */
@Data
public class SaveStockRecordRemarkRequest {
    Integer stockRecordId;
    String remark;
}
