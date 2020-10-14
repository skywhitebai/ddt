package com.sky.ddt.dto.transportType.request;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;

/**
 * @author baixueping
 * @description 列表查询运输方式
 * @date 2020/7/2 11:25
 */
@Data
public class ListTransportTypeRequest extends DataGridRequest{
    String transportTypeName;
}
