package com.sky.ddt.dto.storageLocation.response;

import com.sky.ddt.entity.StorageLocation;
import lombok.Data;

/**
 * @author sky
 * @Description 返回信息
 * @date 2022/1/3 21:12
 */
@Data
public class ListStorageLocationResponse extends StorageLocation {
    String shopName;
}
