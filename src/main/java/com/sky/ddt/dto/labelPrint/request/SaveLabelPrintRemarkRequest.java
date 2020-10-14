package com.sky.ddt.dto.labelPrint.request;

import lombok.Data;

/**
 * @author baixueping
 * @description 保存标签打印备注
 * @date 2020/4/20 10:47
 */
@Data
public class SaveLabelPrintRemarkRequest {
    Integer labelPrintId;
    String remark;
}
