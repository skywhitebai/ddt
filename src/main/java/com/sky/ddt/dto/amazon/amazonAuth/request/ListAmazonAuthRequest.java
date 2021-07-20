package com.sky.ddt.dto.amazon.amazonAuth.request;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;

/**
 * @author baixueping
 * @description 列表查询亚马逊授权信息
 * @date 2021/6/24 11:10
 */
@Data
public class ListAmazonAuthRequest extends DataGridRequest {
    String merchantId;
    Integer shopId;
    Integer status;
}
