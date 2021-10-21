package com.sky.ddt.dto.productLabourCostHis.response;

import com.sky.ddt.entity.ProductLabourCostHis;
import lombok.Data;

/**
 * @author sky
 * @Description 产品工价历史
 * @date 2021/10/21 19:27
 */
@Data
public class ListProductLabourCostHisResponse extends ProductLabourCostHis {
    String createUserName;
    String typeName;
    String productCode;
}
