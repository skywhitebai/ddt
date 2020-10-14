package com.sky.ddt.dto.sys.right.request;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;

/**
 * @author baixueping
 * @description 列表查询权限
 * @date 2020/9/22 17:33
 */
@Data
public class ListRightRequest extends DataGridRequest {
    Integer menuId;
    String rightName;
    String rightStr;
}
