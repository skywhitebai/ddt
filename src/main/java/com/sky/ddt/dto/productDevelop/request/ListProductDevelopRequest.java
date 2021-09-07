package com.sky.ddt.dto.productDevelop.request;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;

/**
 * @author sky
 * @Description TODO
 * @date 2021/9/1 21:55
 */
@Data
public class ListProductDevelopRequest extends DataGridRequest {
    private String productName;
    private String productCode;
    private Integer developerUserId;
    private Integer status;
}
