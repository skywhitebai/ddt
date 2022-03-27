package com.sky.ddt.dto.salesGroup.resp;

import com.sky.ddt.entity.SalesGroup;
import lombok.Data;

/**
 * @author sky
 * @Description
 * @date 2022/3/27 12:20
 */
@Data
public class ListSalesGroupResp extends SalesGroup {
    String realNames;
}
