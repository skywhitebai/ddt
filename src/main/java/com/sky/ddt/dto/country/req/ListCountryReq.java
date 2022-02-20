package com.sky.ddt.dto.country.req;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;

/**
 * @author sky
 * @Description 列表查询国家
 * @date 2022/2/20 15:40
 */
@Data
public class ListCountryReq extends DataGridRequest {
    String countryName;
    Integer currencyId;
    Integer status;
}
