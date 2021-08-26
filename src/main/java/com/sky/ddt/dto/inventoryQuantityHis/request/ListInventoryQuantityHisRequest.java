package com.sky.ddt.dto.inventoryQuantityHis.request;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

/**
 * @author sky
 * @Description 查询库存历史
 * @date 2021/8/21 12:32
 */
@Data
public class ListInventoryQuantityHisRequest extends DataGridRequest {
    String productCode;
    String sku;
    @NotEmpty(message = "查询类型不能为空")
    String searchType;
    String month;
    Date monthDate;
}
