package com.sky.ddt.dto.shopUser.Request;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;

/**
 * @author baixueping
 * @description  店铺用户
 * @date 2019/7/25 11:04
 */
@Data
public class GetShopUserListRequest extends DataGridRequest {
    Integer shopId;
}