package com.sky.ddt.dto.currency.req;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;

/**
 * @author sky
 * @Description 列表查询货币
 * @date 2022/2/20 15:40
 */
@Data
public class ListCurrencyReq extends DataGridRequest {
    String currencyName;
    String currencyCode;
}
