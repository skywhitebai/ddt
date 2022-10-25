package com.sky.ddt.dto.stockRemark.req;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author sky
 * @Description 添加备注
 * @date 2022/10/25 22:18
 */
@Data
public class SaveStockRemarkReq {
    @NotNull(message = "店铺skuid不能为空")
    Integer shopSkuId;
    String remark;
}
