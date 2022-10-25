package com.sky.ddt.dto.stockRemark.req;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author sky
 * @Description 查询
 * @date 2022/10/25 22:18
 */
@Data
public class ListStockRemarkReq extends DataGridRequest {
    @NotNull(message = "店铺skuid不能为空")
    Integer shopSkuId;
}
