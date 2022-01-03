package com.sky.ddt.dto.storageLocation.request;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;

/**
 * @author sky
 * @Description 查询库位入仓
 * @date 2022/1/3 21:10
 */
@Data
public class ListStorageLocationRequest extends DataGridRequest {
    String locationNo;
}
